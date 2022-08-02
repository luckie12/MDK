package com.luckie12.tutorialmod.screen;

import com.luckie12.tutorialmod.block.ModBlocks;
import com.luckie12.tutorialmod.block.entity.custom.GemCuttingStationBlockEntity;
import com.luckie12.tutorialmod.screen.slot.ModResultSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class GemCuttingStationMenu extends AbstractContainerMenu {

    private final GemCuttingStationBlockEntity blockEntity;
    private final Level level;

    public GemCuttingStationMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.getLevel().getBlockEntity(extraData.readBlockPos()));
    }

    public GemCuttingStationMenu(int pContainerId, Inventory inv, BlockEntity entity) {
        super(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), pContainerId);
        checkContainerSize(inv, 4);
        blockEntity = ((GemCuttingStationBlockEntity) entity);
        this.level = inv.player.level;
        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 34, 40));
            this.addSlot(new SlotItemHandler(handler, 1, 57, 18));
            this.addSlot(new SlotItemHandler(handler, 2, 103, 18));
            this.addSlot(new ModResultSlot(handler, 3, 80, 60));
        });

    }

    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, ModBlocks.GEM_CUTTING_STATION.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 9; l++) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8+ i * 18, 144));
        }
    }
}
