package com.starfish_studios.another_furniture.registry;

import com.starfish_studios.another_furniture.entity.SeatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class AFEntityTypes {
    public static final Supplier<EntityType<SeatEntity>> SEAT = AFRegistry.registerEntityType("seat", (type, world) -> new SeatEntity(world), MobCategory.MISC, 0.0F, 0.0F);

    public static void init() {}
}
