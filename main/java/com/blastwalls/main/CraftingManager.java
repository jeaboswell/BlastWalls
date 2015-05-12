package com.blastwalls.main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.blastwalls.blocks.MBlocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingManager {

	public static void mainRegistry(){
		addCraftingRecipie();
		addSmeltingRecipie();
	}
	
	public static void addCraftingRecipie(){
		// Shaped
		GameRegistry.addRecipe(new ItemStack(MBlocks.ClearBlastGlass, 4), new Object[] {"XXX","XYX","XXX", 'X', Blocks.obsidian, 'Y', Blocks.glass});
		GameRegistry.addRecipe(new ItemStack(MBlocks.WhiteBlastGlass, 4), new Object[] {"XXX","XYX","XXX", 'X', MBlocks.ClearBlastGlass, 'Y', new ItemStack(Items.dye, 1, 15)});
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.WhiteBlastBlock, 4), new Object[] {"XXX","XYX","XXX", 'X', Blocks.obsidian, 'Y', new ItemStack(Items.dye, 1, 15)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.GrayBlastBlock, 4), new Object[] {"XXX","XYX","XXX", 'X', Blocks.obsidian, 'Y', new ItemStack(Items.dye, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.LightGrayBlastBlock, 4), new Object[] {"XXX","XYX","XXX", 'X', Blocks.obsidian, 'Y', new ItemStack(Items.dye, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.BlackBlastBlock, 4), new Object[] {"XXX","XYX","XXX", 'X', Blocks.obsidian, 'Y', new ItemStack(Items.dye, 1, 0)});
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.BlueBlastLamp, 6), new Object[] {"XGX","XDX","XGX", 'X', MBlocks.ClearBlastGlass, 'G', Blocks.glowstone, 'D', new ItemStack(Items.dye, 1, 4)});
		// Shapeless
	}
	
	public static void addSmeltingRecipie(){
		
	}
}
