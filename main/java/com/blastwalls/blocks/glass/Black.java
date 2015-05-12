package com.blastwalls.blocks.glass;

import java.util.Random;

import com.blastwalls.lib.RefStrings;
import com.blastwalls.main.ConnectedTextures;
import com.blastwalls.main.MainRegistry;
import com.blastwalls.tileentity.BlockEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class Black extends ConnectedTextures implements ITileEntityProvider {

	int a1 = 0,a2 = 0,a3 = 0,a4 = 0,a5 = 0,a6 = 0;
	
	IIcon gor = null, dol = null, st1 = null, st2 = null, st3 = null, st4 = null;
	
	boolean red = false;
	
	private EntityPlayer owner = null;
	
	public Black(String name, String path) {
		super(Material.glass, path, RefStrings.MODID);
		
		this.setBlockName(name);
		this.setCreativeTab(MainRegistry.mytab);
		this.setBlockTextureName(RefStrings.MODID + ":" + path + "0");
		this.setHardness(2.0F);
		this.setResistance(6000000.0F);
		this.setLightOpacity(0);
		this.setLightLevel(0.0F);
		this.setStepSound(Block.soundTypeGlass);
		
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
		EntityPlayer entity = owner = Minecraft.getMinecraft().thePlayer;
		if(entity!=null&&world!=null){
		int le = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(i, j, k, le, 2);
		}
	
		world.scheduleBlockUpdate(i, j, k, this, this.tickRate(world));
	}
	
	public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
		return red?1:0;
	}
	
	public int getRenderBlockPass() {
		return 1;
	}
	
	public boolean isOpaqueCube() //Tells the game if the block is transparent
	{
         return false;
	}

	public boolean renderAsNormalBlock() //Tells the game how to render the block
	{
         return false;
	}

	protected boolean canSilkHarvest() //Tells the game if silk touch can harvest the block
	{
         return true;
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
	
	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
	{
	    BlockEntity temp = (BlockEntity)world.getTileEntity(x, y, z);
	    String current = null, owner = null;
	    boolean creative = false;
	    
	    try {
	    	current = player.getDisplayName();
	    	creative = player.capabilities.isCreativeMode;
	    	owner = temp.getOwner().getDisplayName();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    if (current.equals(owner) || creative) {
	    	return world.setBlockToAir(x, y, z);
	    }
	    else {
	    	player.addChatMessage(new ChatComponentTranslation("msg.wrongOwner.txt"));
	    	return false;
	    }
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return new BlockEntity(owner);
	}
	
	@Override
	public boolean hasTileEntity(int metadata){
		return true;
	}
}
