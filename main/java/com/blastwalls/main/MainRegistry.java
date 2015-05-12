package com.blastwalls.main;

import net.minecraft.creativetab.CreativeTabs;

import com.blastwalls.blocks.MBlocks;
import com.blastwalls.lib.RefStrings;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION)

public class MainRegistry {
	
	@SidedProxy(clientSide = RefStrings.CLIENTSIDE, serverSide = RefStrings.SERVERSIDE)
	
	public static ServerProxy proxy;
	public static CreativeTabs mytab = new myTab(CreativeTabs.getNextID(), "mytab");
	
	@Mod.EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent){
		MBlocks.mainRegistry();
		CraftingManager.mainRegistry();
		proxy.registerRenderInfo();
	}
	
	@Mod.EventHandler
	public static void Load(FMLInitializationEvent event){
		proxy.registerTileEntities();
	}
	
	@Mod.EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent){
		
	}
}

