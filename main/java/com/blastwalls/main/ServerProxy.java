package com.blastwalls.main;

import com.blastwalls.tileentity.BlockEntity;

import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {

	public void registerRenderInfo(){
		
	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(BlockEntity.class, BlockEntity.publicName); 
	}
}
