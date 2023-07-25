package com.starfish_studios.another_furniture.block;

import com.starfish_studios.another_furniture.block.properties.ModBlockStateProperties;
import com.starfish_studios.another_furniture.registry.AFBlocks;
import com.starfish_studios.another_furniture.registry.AFItemTags;
import com.starfish_studios.another_furniture.util.block.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class LampBlock extends Block implements SimpleWaterloggedBlock {
    protected static final int LEVEL_MIN = 1;
    protected static final int LEVEL_MAX = 3;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final DirectionProperty FACING = ModBlockStateProperties.FACING_EXCEPT_DOWN;
    public static final IntegerProperty LEVEL = ModBlockStateProperties.LEVEL_1_3;
    public static final BooleanProperty BASE = ModBlockStateProperties.BASE;

    protected static final VoxelShape AABB_UP = Block.box(3.0D, 8.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    protected static final VoxelShape AABB_UP_NORMAL = Shapes.or(AABB_UP, Block.box(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D));
    protected static final VoxelShape AABB_UP_TOP = Shapes.or(AABB_UP, Block.box(7.0D, 0.0D, 7.0D, 9.0D, 8.0D, 9.0D));
    protected static final VoxelShape AABB_NORTH = Shapes.or(
            Block.box(3.0D, 8.0D, 5.0D, 13.0D, 16.0D, 15.0D),
            Block.box(5.0D, 0.0D, 14.0D, 11.0D, 6.0D, 16.0D),
            Block.box(7.0D, 2.0D, 9.0D, 9.0D, 8.0D, 11.0D),
            Block.box(7.0D, 2.0D, 11.0D, 9.0D, 4.0D, 14.0D));
    protected static final VoxelShape AABB_EAST = ShapeUtil.rotateShape(AABB_NORTH, Direction.EAST);
    protected static final VoxelShape AABB_SOUTH = ShapeUtil.rotateShape(AABB_NORTH, Direction.SOUTH);
    protected static final VoxelShape AABB_WEST = ShapeUtil.rotateShape(AABB_NORTH, Direction.WEST);

    private final DyeColor color;
    public LampBlock(DyeColor color, Properties properties) {
        super(properties);
        this.color = color;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.UP)
                .setValue(LEVEL, LEVEL_MAX)
                .setValue(LIT, true)
                .setValue(POWERED, false)
                .setValue(WATERLOGGED, false)
                .setValue(BASE, true));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> AABB_NORTH;
            case EAST -> AABB_EAST;
            case SOUTH -> AABB_SOUTH;
            case WEST -> AABB_WEST;
            default -> state.getValue(BASE) ? AABB_UP_NORMAL : AABB_UP_TOP;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        Direction clickedFace = context.getClickedFace();
        BlockState blockstate = this.defaultBlockState();
        if (level.hasNeighborSignal(pos)) {
            blockstate = blockstate.setValue(POWERED, true);
        }

        return clickedFace != Direction.DOWN ? blockstate.setValue(FACING, clickedFace).setValue(WATERLOGGED, waterlogged) : null;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (!state.canSurvive(level, currentPos)) return Blocks.AIR.defaultBlockState();

        if (state.getValue(WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        if (state.getValue(FACING) == Direction.UP && (direction == Direction.UP || direction == Direction.DOWN)) {
            BlockState aState = level.getBlockState(currentPos.above());
            BlockState bState = level.getBlockState(currentPos.below());
            boolean aConnect = (aState.getBlock() instanceof LampBlock && aState.getValue(FACING) == Direction.UP) || aState.getBlock() instanceof LampConnectorBlock;
            boolean bConnect = (bState.getBlock() instanceof LampBlock && bState.getValue(FACING) == Direction.UP) || bState.getBlock() instanceof LampConnectorBlock;

            if (aConnect && !bConnect) state = AFBlocks.LAMP_CONNECTOR.get().defaultBlockState().setValue(BASE, true).setValue(LampConnectorBlock.COLOR, color).setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            else if (!aConnect && bConnect) state = state.setValue(BASE, false);
            else if (aConnect) state = AFBlocks.LAMP_CONNECTOR.get().defaultBlockState().setValue(BASE, false).setValue(LampConnectorBlock.COLOR, color).setValue(WATERLOGGED, state.getValue(WATERLOGGED));
            else state = state.setValue(BASE, true);
        }

        return state;
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos facingPos = pos.relative(direction.getOpposite());
        BlockState facingState = level.getBlockState(facingPos);
        return direction == Direction.UP || facingState.isFaceSturdy(level, facingPos, direction);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide) return;

        BlockState below = level.getBlockState(pos.below());
        boolean powered = level.hasNeighborSignal(pos) || (below.getBlock() instanceof LampConnectorBlock && below.getValue(POWERED));
        if (powered != state.getValue(POWERED)) {
            if (state.getValue(LIT) != powered) {
                state = state.setValue(LIT, powered);
                level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
            state = state.setValue(POWERED, powered);
        }
        level.setBlock(pos, state, 3);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (player.getItemInHand(hand).is(AFItemTags.LAMPS) && state.getValue(FACING) == Direction.UP && hit.getDirection() == Direction.UP) {
            return InteractionResult.FAIL;
        }
        if (player.isCrouching()) {
            int light = state.getValue(LEVEL);
            light = light >= LEVEL_MAX ? LEVEL_MIN : light + 1;
            state = state.setValue(LEVEL, light);
        } else {
            state = state.cycle(LIT);

        }
        level.setBlock(pos, state, 3);
        level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 1.0f, 1.0f);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, LIT, POWERED, FACING, LEVEL, BASE);
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