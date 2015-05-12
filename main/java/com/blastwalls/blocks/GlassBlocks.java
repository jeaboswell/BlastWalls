package com.blastwalls.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.blastwalls.lib.RefStrings;
import com.blastwalls.main.ConnectedTextures;
import com.blastwalls.main.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GlassBlocks extends ConnectedTextures {

	@SideOnly(Side.CLIENT)
	private String[] paths;
	
	final static String[] subBlocks = new String[] {"Clear", "White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Gray", "LightGray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
	
	public GlassBlocks(String path) {
		super(Material.glass, path, RefStrings.MODID);
		
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
	private void setPaths() {
		paths = new String[subBlocks.length];
		
		for (int i=0; i < subBlocks.length; i++) {
			paths[i] = "Glass/" + subBlocks[i] + "/Glass_";
		}
	}

}
