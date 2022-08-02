package com.luckie12.tutorialmod.block.entity;

import com.luckie12.tutorialmod.TutorialMod;
import com.luckie12.tutorialmod.block.ModBlocks;
import com.luckie12.tutorialmod.block.entity.custom.GemCuttingStationBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENNTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemCuttingStationBlockEntity>> GEM_CUTTING_STATION_BLOCK_ENTITY =
            BLOCK_ENNTITIES.register("gem_cutting_station_block_entity", () -> BlockEntityType.Builder.of(GemCuttingStationBlockEntity::new, ModBlocks.ZIRCON_LAMP.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENNTITIES.register(eventBus);
    }

}
