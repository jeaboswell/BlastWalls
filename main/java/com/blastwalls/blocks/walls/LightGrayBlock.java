package com.blastwalls.blocks.walls;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.blastwalls.lib.RefStrings;
import com.blastwalls.main.ConnectedTextures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LightGrayBlock extends ConnectedTextures{
	
	int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,a6 = 0;
	
	IIcon gor = null, dol = null, st1 = null, st2 = null, st3 = null, st4 = null;
	
	boolean red = false;
	
	public LightGrayBlock(String name, String path) {
		super(Material.rock, path, RefStrings.MODID);
		
		this.setBlockName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName(RefStrings.MODID + ":" + path + "0");
		this.setHardness(2.0F);
		this.setResistance(6000000.0F);
		this.setLightOpacity(255);
		this.setLightLevel(0.0F);
		this.setStepSound(Block.soundTypeStone);
		
		this.Falone = 0;
        this.Fedge3 = 1;
        this.Fcorner = 5;
        this.Fsurrounded = 9;
        this.FinLine = 10;
        this.Fjust1 = 12;
        this.Fnotches = 16;
	}
	
	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World world, int i, int j, int k){
		EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
		if(entity!=null&&world!=null){
		int le = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(i, j, k, le, 2);
		}
	
		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));
	}
	
	public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
		return red?1:0;
	}
	
	public int getRenderType(){
		return 0;
	}
	
	@Override
	public int tickRate(World world)
	{
	    return 10;
	}
	
	public int quantityDropped(Random par1Random){
		return 1;
	}
}
