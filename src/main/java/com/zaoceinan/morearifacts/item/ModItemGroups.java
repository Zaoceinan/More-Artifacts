package com.zaoceinan.morearifacts.item;

import com.zaoceinan.morearifacts.MoreArtifacts;
import com.zaoceinan.morearifacts.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> MoreArtifacts_GROUP = RegistryKey.of(
            RegistryKeys.ITEM_GROUP, Identifier.of(MoreArtifacts.MOD_ID, "moreartifacts_group"));

    public static void registerModItemGroups() {
        // 确保 magic_ingot 已初始化
        if (ModItems.magic_ingot == null) {
            throw new IllegalStateException("magic_ingot is not initialized!");
        }

        Registry.register(Registries.ITEM_GROUP, MoreArtifacts_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.moreartifacts_group"))
                        .icon(() -> new ItemStack(ModItems.magic_ingot))
                        .entries((context, entries) -> {
                            entries.add(ModItems.magic_ingot);
                            entries.add(ModBlocks.magic_block);
                            entries.add(ModBlocks.magic_ore);
                        })
                        .build());

        if (MoreArtifacts.LOGGER.isInfoEnabled()) {
            MoreArtifacts.LOGGER.info("Registering Item Groups");
        }
    }
}