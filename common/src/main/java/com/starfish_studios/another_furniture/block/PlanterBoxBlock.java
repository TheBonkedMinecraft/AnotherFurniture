package com.starfish_studios.another_furniture.block;

import com.starfish_studios.another_furniture.block.entity.PlanterBoxBlockEntity;
import com.starfish_studios.another_furniture.block.properties.HorizontalConnectionType;
import com.starfish_studios.another_furniture.block.properties.ModBlockStateProperties;
import com.starfish_studios.another_furniture.registry.AFItemTags;
import com.starfish_studios.another_furniture.util.block.BlockPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PlanterBoxBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<HorizontalConnectionType> TYPE = ModBlockStateProperties.HORIZONTAL_CONNECTION_TYPE;
    public static final BooleanProperty ATTACHED = BlockStateProperties.ATTACHED;
    protected static final VoxelShape NORTH_AABB = Block.box(0, 10, 8, 16, 16, 16);
    protected static final VoxelShape SOUTH_AABB = Block.box(0, 10, 0, 16, 16, 8);
    protected static final VoxelShape WEST_AABB = Block.box(8, 10, 0, 16, 16, 16);
    protected static final VoxelShape EAST_AABB = Block.box(0, 10, 0, 8, 16, 16);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(0, 0, 4, 16, 6, 12);
    protected static final VoxelShape X_AXIS_AABB = Block.box(4, 0, 0, 12, 6, 16);

    public PlanterBoxBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TYPE, HorizontalConnectionType.SINGLE)
                .setValue(ATTACHED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        boolean attached = state.getValue(ATTACHED);
        return switch (state.getValue(FACING)) {
            case WEST -> attached ? WEST_AABB : X_AXIS_AABB;
            case EAST -> attached ? EAST_AABB : X_AXIS_AABB;
            case SOUTH -> attached ? SOUTH_AABB : Z_AXIS_AABB;
            default -> attached ? NORTH_AABB : Z_AXIS_AABB;
        };
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(ATTACHED)) {
            Direction direction = state.getValue(FACING);
            BlockPos facingPos = pos.relative(direction.getOpposite());
            BlockState facingState = level.getBlockState(facingPos);
            return facingState.isFaceSturdy(level, facingPos, direction);
        }
        return super.canSurvive(state, level, pos);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        BlockState above = level.getBlockState(currentPos.above());
        boolean attached = state.getValue(ATTACHED);
        if (direction == Direction.UP && attached && above.isFaceSturdy(level, currentPos, Direction.DOWN)) {
            BlockEntity blockentity = level.getBlockEntity(currentPos);
            if (blockentity instanceof PlanterBoxBlockEntity planterBoxBE) {
                planterBoxBE.removeAllItems();
                return state;
            }
        }

        Direction facing = state.getValue(FACING);
        if (attached && direction.getOpposite() == facing && !state.canSurvive(level, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        if (direction != facing.getClockWise() && direction != facing.getCounterClockWise()) return state;
        BlockState l_state = level.getBlockState(currentPos.relative(facing.getClockWise()));
        BlockState r_state = level.getBlockState(currentPos.relative(facing.getCounterClockWise()));
        boolean l_side = (l_state.getBlock() instanceof PlanterBoxBlock && l_state.getValue(ATTACHED) == attached && (l_state.getValue(FACING) == facing || (!attached && l_state.getValue(FACING) == facing.getOpposite())));
        boolean r_side = (r_state.getBlock() instanceof PlanterBoxBlock && r_state.getValue(ATTACHED) == attached && (r_state.getValue(FACING) == facing || (!attached && r_state.getValue(FACING) == facing.getOpposite())));
        HorizontalConnectionType type = l_side && r_side ? HorizontalConnectionType.MIDDLE : (r_side ? HorizontalConnectionType.LEFT : (l_side ? HorizontalConnectionType.RIGHT : HorizontalConnectionType.SINGLE));
        return state.setValue(TYPE, type);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();
        boolean attached = !(clickedFace == Direction.UP || clickedFace == Direction.DOWN);
        Direction facing = attached ? clickedFace : context.getHorizontalDirection().getOpposite();
        return this.defaultBlockState().setValue(ATTACHED, attached).setValue(FACING, facing);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, ATTACHED);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PlanterBoxBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof PlanterBoxBlockEntity planterBoxBE)) return InteractionResult.PASS;

        ItemStack stack = player.getItemInHand(hand);
        if (!stack.is(AFItemTags.PLANTER_BOX_PLACEABLES) || stack.is(AFItemTags.PLANTER_BOX_BANNED)) return InteractionResult.PASS;

        Direction facing = state.getValue(FACING);
        int slot = BlockPart.get1D(pos, hit.getLocation(), facing.getClockWise(), 2);
        if (!level.isClientSide && planterBoxBE.placeFlower(player.getAbilities().instabuild ? stack.copy() : stack, slot))
            return InteractionResult.SUCCESS;

        return InteractionResult.CONSUME;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.is(newState.getBlock())) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof PlanterBoxBlockEntity planterBoxBE) Containers.dropContents(level, pos, planterBoxBE.getItems());
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
