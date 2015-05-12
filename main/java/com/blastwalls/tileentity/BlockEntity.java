package com.blastwalls.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEntity extends TileEntity{

	public static final String publicName = "BlockEntity";
	private EntityPlayer owner; 
	
	
	public BlockEntity(EntityPlayer player) {
		this.owner = player;
	}
	
	public EntityPlayer getOwner() {
		return owner;
	}
}
