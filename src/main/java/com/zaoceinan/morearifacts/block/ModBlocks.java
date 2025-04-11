package com.zaoceinan.morearifacts.block;

import com.zaoceinan.morearifacts.MoreArtifacts;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block magic_block = register("magic_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0f, 3.0f)));
    public static final Block magic_ore = register("magic_ore", new Block(AbstractBlock.Settings.create().requiresTool().strength(4.0f, 6.0f)));

    public static void registerBlockItems(String id, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MoreArtifacts.MOD_ID, id), new BlockItem(block, new Item.Settings()));
    }

    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MoreArtifacts.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        MoreArtifacts.LOGGER.info("Registering Blocks");
    }
}