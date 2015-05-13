package com.blastwalls.blocks;

import com.blastwalls.blocks.glass.*;
import com.blastwalls.blocks.lights.*;
import com.blastwalls.blocks.walls.*;
import com.blastwalls.lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

public class MBlocks {

	public static void mainRegistry(){
		initializeBlock();
		registerBlock();
	}
	// Glass blocks
	public static Block ClearBlastGlass;
	public static Block WhiteBlastGlass;
	public static Block OrangeBlastGlass;
	public static Block MagentaBlastGlass;
	public static Block LightBlueBlastGlass;
	public static Block YellowBlastGlass;
	public static Block LimeBlastGlass;
	public static Block PinkBlastGlass;
	public static Block GrayBlastGlass;
	public static Block LightGrayBlastGlass;
	public static Block CyanBlastGlass;
	public static Block PurpleBlastGlass;
	public static Block BlueBlastGlass;
	public static Block BrownBlastGlass;
	public static Block GreenBlastGlass;
	public static Block RedBlastGlass;
	public static Block BlackBlastGlass;
	// Wall blocks
	public static Block WhiteBlastBlock;
	public static Block GrayBlastBlock;
	public static Block LightGrayBlastBlock;
	public static Block BlackBlastBlock;
	// Light blocks
	public static Block BlueBlastLamp;
	
	public static void initializeBlock(){
		ClearBlastGlass = new Clear("ClearBlastGlass", "Glass/Clear/Glass_");
		WhiteBlastGlass = new White("WhiteBlastGlass", "Glass/White/Glass_");
		OrangeBlastGlass = new Orange("OrangeBlastGlass", "Glass/Orange/Glass_");
		MagentaBlastGlass = new Magenta("MagentaBlastGlass", "Glass/Magenta/Glass_");
		LightBlueBlastGlass = new LightBlue("LightBlueBlastGlass", "Glass/LightBlue/Glass_");
		YellowBlastGlass = new Yellow("YellowBlastGlass", "Glass/Yellow/Glass_");
		LimeBlastGlass = new Lime("LimeBlastGlass", "Glass/Lime/Glass_");
		PinkBlastGlass = new Pink("PinkBlastGlass", "Glass/Pink/Glass_");
		GrayBlastGlass = new Gray("GrayBlastGlass", "Glass/Gray/Glass_");
		LightGrayBlastGlass = new LightGray("LightGrayBlastGlass", "Glass/LightGray/Glass_");
		CyanBlastGlass = new Cyan("CyanBlastGlass", "Glass/Cyan/Glass_");
		PurpleBlastGlass = new Purple("PurpleBlastGlass", "Glass/Purple/Glass_");
		BlueBlastGlass = new Blue("BlueBlastGlass", "Glass/Blue/Glass_");
		BrownBlastGlass = new Brown("BrownBlastGlass", "Glass/Brown/Glass_");
		GreenBlastGlass = new Green("GreenBlastGlass", "Glass/Green/Glass_");
		RedBlastGlass = new Red("RedBlastGlass", "Glass/Red/Glass_");
		BlackBlastGlass = new Black("BlackBlastGlass", "Glass/Black/Glass_");
		
		WhiteBlastBlock = new WhiteBlock("WhiteBlastBlock", "Walls/WhiteBlock/Block_");
		GrayBlastBlock = new GrayBlock("GrayBlastBlock", "Walls/GrayBlock/Block_");
		LightGrayBlastBlock = new LightGrayBlock("LightGrayBlastBlock", "Walls/LightGrayBlock/GreyBlock_");
		BlackBlastBlock = new BlackBlock("BlackBlastBlock", "Walls/BlackBlock/Block_");
		
		BlueBlastLamp = new BlueLamp("BlueBlastLamp", "Lights/BlueLamp/Lamp_");
	}
	
	public static void registerBlock(){
		GameRegistry.registerBlock(ClearBlastGlass, "ClearBlastGlass");
		GameRegistry.registerBlock(WhiteBlastGlass, "WhiteBlastGlass");
		GameRegistry.registerBlock(OrangeBlastGlass, "OrangeBlastGlass");
		GameRegistry.registerBlock(MagentaBlastGlass, "MagentaBlastGlass");
		GameRegistry.registerBlock(LightBlueBlastGlass, "LightBlueBlastGlass");
		GameRegistry.registerBlock(YellowBlastGlass, "YellowBlastGlass");
		GameRegistry.registerBlock(LimeBlastGlass, "LimeBlastGlass");
		GameRegistry.registerBlock(PinkBlastGlass, "PinkBlastGlass");
		GameRegistry.registerBlock(GrayBlastGlass, "GrayBlastGlass");
		GameRegistry.registerBlock(LightGrayBlastGlass, "LightGrayBlastGlass");
		GameRegistry.registerBlock(CyanBlastGlass, "CyanBlastGlass");
		GameRegistry.registerBlock(PurpleBlastGlass, "PurpleBlastGlass");
		GameRegistry.registerBlock(BlueBlastGlass, "BlueBlastGlass");
		GameRegistry.registerBlock(BrownBlastGlass, "BrownBlastGlass");
		GameRegistry.registerBlock(GreenBlastGlass, "GreenBlastGlass");
		GameRegistry.registerBlock(RedBlastGlass, "RedBlastGlass");
		GameRegistry.registerBlock(BlackBlastGlass, "BlackBlastGlass");
		
		GameRegistry.registerBlock(WhiteBlastBlock, "WhiteBlastBlock");
		GameRegistry.registerBlock(GrayBlastBlock, "GrayBlastBlock");
		GameRegistry.registerBlock(LightGrayBlastBlock, "LightGrayBlastBlock");
		GameRegistry.registerBlock(BlackBlastBlock, "BlackBlastBlock");
		
		GameRegistry.registerBlock(BlueBlastLamp, "BlueBlastLamp");
	}
	
	
}