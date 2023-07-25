//package com.starfish_studios.another_furniture.integration.fabric.create;

//import com.simibubi.create.content.contraptions.components.structureMovement.Contraption;
//import com.simibubi.create.content.contraptions.components.structureMovement.MovementBehaviour;
//import com.simibubi.create.content.contraptions.components.structureMovement.MovementContext;
//import com.starfish_studios.another_furniture.block.ShutterBlock;
//import com.starfish_studios.another_furniture.block.properties.ShutterType;
//import net.minecraft.core.Direction;
//import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
//
//public class ShutterMovingBehavior implements MovementBehaviour {
//
//
//    @Override
//    public void startMoving(MovementContext context) {
//        if (context.state.getValue(ShutterBlock.TYPE) != ShutterType.MIDDLE) return;
//
//        Direction facing = context.state.getValue(ShutterBlock.FACING);
//        boolean left = context.state.getValue(ShutterBlock.LEFT);
//        boolean open = context.state.getValue(ShutterBlock.OPEN);
//
//        Contraption contraption = context.contraption;
//
//        StructureTemplate.StructureBlockInfo state = contraption.getBlocks().get(context.localPos);
//        StructureTemplate.StructureBlockInfo above = contraption.getBlocks().get(context.localPos.above());
//        StructureTemplate.StructureBlockInfo below = contraption.getBlocks().get(context.localPos.below());
//        System.out.println(state.state);
//        if (above != null) System.out.println(above.state);
//        if (below != null) System.out.println(below.state);
//
//        boolean shape_above_same = above != null && above.state.is(context.state.getBlock()) && above.state.getValue(ShutterBlock.FACING) == facing
//                && above.state.getValue(ShutterBlock.OPEN) == open && above.state.getValue(ShutterBlock.LEFT) == left;
//        boolean shape_below_same = below != null && below.state.is(context.state.getBlock()) && below.state.getValue(ShutterBlock.FACING) == facing
//                && below.state.getValue(ShutterBlock.OPEN) == open && below.state.getValue(ShutterBlock.LEFT) == left;
//
//        if (shape_above_same && !shape_below_same) contraption.getBlocks().put(context.localPos, new StructureTemplate.StructureBlockInfo(state.pos, context.state.setValue(ShutterBlock.TYPE, ShutterType.BOTTOM), state.nbt));
//        else if (!shape_above_same && shape_below_same) contraption.getBlocks().put(context.localPos, new StructureTemplate.StructureBlockInfo(state.pos, context.state.setValue(ShutterBlock.TYPE, ShutterType.TOP), state.nbt));
//        else if (!shape_above_same) contraption.getBlocks().put(context.localPos, new StructureTemplate.StructureBlockInfo(state.pos, context.state.setValue(ShutterBlock.TYPE, ShutterType.NONE), state.nbt));
//    }
//
//
//}
