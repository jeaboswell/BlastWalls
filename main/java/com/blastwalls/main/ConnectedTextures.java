package com.blastwalls.main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
public class ConnectedTextures extends Block {
       
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    private String modId;
    private String path;
    
    /**just by itself<br>1*/
    public int Falone;
    
    /**xxx<br>xAA<br>xxx<br>4*/
    public int Fjust1=-1;
    
    /**xAx<br>xAA<br>xAx<br>4*/
    public int Fedge3=-1;
    
    /**xxx<br>xAA<br>xAx<br>4*/
    public int Fcorner=-1;
    
    /**xAx<br>xAx<br>xAx<br>3*/
    public int FinLine=-1;
    
    /**AAA<br>AAA<br>AAA<br>1*/
    public int Fsurrounded=-1;
    
    public int Fnotches=-1;
    
    public Block[] FblockConnectionAllowed = new Block[]{this};
   
    /**
     * NB: set at least some of the public fields to tell getIcon how to behave (the last number tells you how many textures will be needed.<br>
     * follow the order given by you)<br>
     * The block base texture (for when rendered in hand or such) is (string) path+"0" and should be the block texture for when Falone. Change this if needed.
     * @param material
     * @param path texture path (will end with a number that is added automatically based on the public field)
     * @param modId used to get the texture
     */
    public ConnectedTextures(Material material, String path, String modId) {
            super(material);
            this.path=path;
            this.modId=modId;
            this.setBlockTextureName(modId+":"+path+"0");
    }
   
    /**
     * Don't touch this either
     * order your textures clock-wise from the top one (and play with it a bit).
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        super.registerBlockIcons(reg);
        int amount=0;
        if (Falone!=-1) amount++;
        if (Fedge3!=-1) amount+=4;
        if (Fcorner!=-1) amount+=4;
        if (Fsurrounded!=-1) amount++;
        if (FinLine!=-1) amount+=2;
        if (Fjust1!=-1) amount+=4;
        if (Fnotches!=-1) amount+=31;
        this.icons = new IIcon[amount];
        for (int i = 0; i < icons.length; ++i) {
            this.icons[i] = reg.registerIcon(modId+":"+path+i);
        }
    }
 
    /**
     * This is the reason you downloaded this API, so don't touch this
     * NB: the order of the matches is:
     * 1) Fsurrounded and Falone
     * 2) Fedge3
     * 3) FinLine
     * 4) Fcorner
     * 5) Fjust1
     * If one fails because there is no set, the next ones will be checked, because only the presence of the block is checked, not its absence.
     * If no icon is found the standard icon is chosen.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        if (!connectionAllowed(world, x, y, z, side)) return icons[0];
        boolean[] a = getB(world, x, y, z);
        boolean[] b = getCornerB(world, x, y, z);
        
        switch (side) {
        case 0: case 1: // Top & Bottom
        	if (Fnotches!=-1) {
        		if (allCornerB(true, b[4], b[6], b[7], b[9]) && allCornerB(false, b[3], b[5], b[8], b[10])) return icons[Fnotches];
				
				if (allCornerB(true, b[3], b[4], b[5], b[6], b[7], b[9]) && allCornerB(false, b[8], b[10])) return icons[Fnotches+1];
				if (allCornerB(true, b[3], b[4], b[6], b[7], b[8], b[9]) && allCornerB(false, b[5], b[10])) return icons[Fnotches+2];
				if (allCornerB(true, b[4], b[6], b[7], b[8], b[9], b[10]) && allCornerB(false, b[3], b[5])) return icons[Fnotches+3];
				if (allCornerB(true, b[4], b[5], b[6], b[7], b[9], b[10]) && allCornerB(false, b[3], b[8])) return icons[Fnotches+4];
				
				if (allCornerB(true, b[3], b[4], b[5], b[6], b[7], b[9], b[10]) && allCornerB(false, b[8])) return icons[Fnotches+5];
				if (allCornerB(true, b[3], b[4], b[5], b[6], b[7], b[8], b[9]) && allCornerB(false, b[10])) return icons[Fnotches+6];
				if (allCornerB(true, b[3], b[4], b[6], b[7], b[8], b[9], b[10]) && allCornerB(false, b[5])) return icons[Fnotches+7];
				if (allCornerB(true, b[4], b[5], b[6], b[7], b[8], b[9], b[10]) && allCornerB(false, b[3])) return icons[Fnotches+8];

				if (allCornerB(true, b[6], b[9]) && allCornerB(false, b[4], b[7], b[8])) return icons[Fnotches+9];
				if (allCornerB(true, b[7], b[9]) && allCornerB(false, b[4], b[6], b[10])) return icons[Fnotches+10];
				if (allCornerB(true, b[4], b[7]) && allCornerB(false, b[5], b[6], b[9])) return icons[Fnotches+11];
				if (allCornerB(true, b[4], b[6]) && allCornerB(false, b[3], b[7], b[9])) return icons[Fnotches+12];
				
				if (allCornerB(true, b[4], b[5], b[6], b[7], b[9]) && allCornerB(false, b[3], b[8], b[10])) return icons[Fnotches+13];
				if (allCornerB(true, b[3], b[4], b[6], b[7], b[9]) && allCornerB(false, b[5], b[8], b[10])) return icons[Fnotches+14];
				if (allCornerB(true, b[4], b[6], b[7], b[8], b[9]) && allCornerB(false, b[3], b[5], b[10])) return icons[Fnotches+15];
				if (allCornerB(true, b[4], b[6], b[7], b[9], b[10]) && allCornerB(false, b[3], b[5], b[8])) return icons[Fnotches+16];
				
				if (allCornerB(true, b[4], b[5], b[6], b[7], b[8], b[9]) && allCornerB(false, b[3], b[10])) return icons[Fnotches+17];
				if (allCornerB(true, b[3], b[4], b[6], b[7], b[9], b[10]) && allCornerB(false, b[5], b[8])) return icons[Fnotches+18];
				
				if (allCornerB(true, b[6], b[7], b[9]) && allCornerB(false, b[4], b[8], b[10])) return icons[Fnotches+19];
				if (allCornerB(true, b[4], b[7], b[9]) && allCornerB(false, b[5], b[6], b[10])) return icons[Fnotches+20];
				if (allCornerB(true, b[4], b[6], b[7]) && allCornerB(false, b[3], b[5], b[9])) return icons[Fnotches+21];
				if (allCornerB(true, b[4], b[6], b[9]) && allCornerB(false, b[3], b[7], b[8])) return icons[Fnotches+22];
				
				if (allCornerB(true, b[6], b[7], b[9], b[10]) && allCornerB(false, b[8])) return icons[Fnotches+23];
				if (allCornerB(true, b[6], b[7], b[9], b[8]) && allCornerB(false, b[10])) return icons[Fnotches+24];
				if (allCornerB(true, b[4], b[5], b[7], b[9]) && allCornerB(false, b[10])) return icons[Fnotches+25];
				if (allCornerB(true, b[4], b[7], b[9], b[10]) && allCornerB(false, b[5])) return icons[Fnotches+26];
				if (allCornerB(true, b[3], b[4], b[6], b[7]) && allCornerB(false, b[5])) return icons[Fnotches+27];
				if (allCornerB(true, b[4], b[5], b[6], b[7]) && allCornerB(false, b[3])) return icons[Fnotches+28];
				if (allCornerB(true, b[4], b[6], b[8], b[9]) && allCornerB(false, b[3])) return icons[Fnotches+29];
				if (allCornerB(true, b[3], b[4], b[6], b[9]) && allCornerB(false, b[8])) return icons[Fnotches+30];
        	} 
        	if ((Fsurrounded!=-1)&&(allB(true, a[2], a[3], a[4], a[5]))) return icons[Fsurrounded];
			if (Fedge3!=-1) {
				if (allB(true, a[2], a[4], a[5])) return icons[Fedge3];
				if (allB(true, a[2], a[3], a[4])) return icons[Fedge3+1];
				if (allB(true, a[3], a[4], a[5])) return icons[Fedge3+2];
				if (allB(true, a[2], a[3], a[5])) return icons[Fedge3+3];
			} if (FinLine!=-1) {
				if (allB(true, a[2], a[3])) return icons[FinLine];
				if (allB(true, a[4], a[5])) return icons[FinLine+1];
			} if (Fcorner!=-1) {
				if (allB(true, a[2], a[5])) return icons[Fcorner];
				if (allB(true, a[2], a[4])) return icons[Fcorner+1];
				if (allB(true, a[3], a[4])) return icons[Fcorner+2];
				if (allB(true, a[3], a[5])) return icons[Fcorner+3];
			} if (Fjust1!=-1) {
				if (a[2]) return icons[Fjust1];
				if (a[3]) return icons[Fjust1+1];
				if (a[4]) return icons[Fjust1+3];
				if (a[5]) return icons[Fjust1+2];
			}
			return icons[Falone];
		case 2: // North
			if (Fnotches!=-1) {
				if (allCornerB(true, b[1], b[6], b[7], b[12]) && allCornerB(false, b[0], b[2], b[11], b[13])) return icons[Fnotches];
				
				if (allCornerB(true, b[1], b[6], b[7], b[11], b[12], b[13]) && allCornerB(false, b[0], b[2])) return icons[Fnotches+1];
				if (allCornerB(true, b[1], b[2], b[6], b[7], b[12], b[13]) && allCornerB(false, b[0], b[11])) return icons[Fnotches+2];
				if (allCornerB(true, b[0], b[1], b[2], b[6], b[7], b[12]) && allCornerB(false, b[11], b[13])) return icons[Fnotches+3];
				if (allCornerB(true, b[0], b[1], b[6], b[7], b[11], b[12]) && allCornerB(false, b[2], b[13])) return icons[Fnotches+4]; 
				
				if (allCornerB(true, b[0], b[1], b[6], b[7], b[11], b[12], b[13]) && allCornerB(false, b[2])) return icons[Fnotches+5];
				if (allCornerB(true, b[1], b[2], b[6], b[7], b[11], b[12], b[13]) && allCornerB(false, b[0])) return icons[Fnotches+6];
				if (allCornerB(true, b[0], b[1], b[2], b[6], b[7], b[12], b[13]) && allCornerB(false, b[11])) return icons[Fnotches+7];
				if (allCornerB(true, b[0], b[1], b[2], b[6], b[7], b[11], b[12]) && allCornerB(false, b[13])) return icons[Fnotches+8]; 

				if (allCornerB(true, b[1], b[7]) && allCornerB(false, b[2], b[6], b[12])) return icons[Fnotches+9];
				if (allCornerB(true, b[1], b[6]) && allCornerB(false, b[0], b[7], b[12])) return icons[Fnotches+10];
				if (allCornerB(true, b[6], b[12]) && allCornerB(false, b[1], b[7], b[11])) return icons[Fnotches+11];
				if (allCornerB(true, b[7], b[12]) && allCornerB(false, b[1], b[6], b[13])) return icons[Fnotches+12]; 
				
				if (allCornerB(true, b[1], b[6], b[7], b[12], b[11]) && allCornerB(false, b[0], b[2], b[13])) return icons[Fnotches+13];
				if (allCornerB(true, b[1], b[6], b[7], b[12], b[13]) && allCornerB(false, b[0], b[2], b[11])) return icons[Fnotches+14];
				if (allCornerB(true, b[1], b[2], b[6], b[7], b[12]) && allCornerB(false, b[0], b[11], b[13])) return icons[Fnotches+15];
				if (allCornerB(true, b[0], b[1], b[6], b[7], b[12]) && allCornerB(false, b[2], b[11], b[13])) return icons[Fnotches+16];

				if (allCornerB(true, b[1], b[2], b[6], b[7], b[11], b[12]) && allCornerB(false, b[0], b[13])) return icons[Fnotches+17];
				if (allCornerB(true, b[0], b[1], b[6], b[7], b[12], b[13]) && allCornerB(false, b[2], b[11])) return icons[Fnotches+18];
				
				if (allCornerB(true, b[1], b[6], b[7]) && allCornerB(false, b[0], b[2], b[12])) return icons[Fnotches+19];
				if (allCornerB(true, b[1], b[6], b[12]) && allCornerB(false, b[0], b[7], b[11])) return icons[Fnotches+20];
				if (allCornerB(true, b[6], b[7], b[12]) && allCornerB(false, b[1], b[11], b[13])) return icons[Fnotches+21];
				if (allCornerB(true, b[1], b[7], b[12]) && allCornerB(false, b[2], b[6], b[13])) return icons[Fnotches+22];
				
				if (allCornerB(true, b[0], b[1], b[6], b[7]) && allCornerB(false, b[2], b[12])) return icons[Fnotches+23];
				if (allCornerB(true, b[1], b[2], b[6], b[7]) && allCornerB(false, b[0], b[12])) return icons[Fnotches+24];
				if (allCornerB(true, b[1], b[6], b[11], b[12]) && allCornerB(false, b[0], b[7])) return icons[Fnotches+25];
				if (allCornerB(true, b[0], b[1], b[6], b[12]) && allCornerB(false, b[7], b[11])) return icons[Fnotches+26];
				if (allCornerB(true, b[6], b[7], b[12], b[13]) && allCornerB(false, b[1], b[11])) return icons[Fnotches+27];
				if (allCornerB(true, b[6], b[7], b[11], b[12]) && allCornerB(false, b[1], b[13])) return icons[Fnotches+28];
				if (allCornerB(true, b[1], b[2], b[7], b[12]) && allCornerB(false, b[6], b[13])) return icons[Fnotches+29];
				if (allCornerB(true, b[1], b[7], b[12], b[13]) && allCornerB(false, b[2], b[6])) return icons[Fnotches+30]; 
        	} 
			if ((Fsurrounded!=-1)&&(allB(true, a[0], a[1], a[4], a[5]))) return icons[Fsurrounded];
			if (Fedge3!=-1) {
				if (allB(true, a[0], a[4], a[5])) return icons[Fedge3];
				if (allB(true, a[0], a[1], a[5])) return icons[Fedge3+1];
				if (allB(true, a[1], a[4], a[5])) return icons[Fedge3+2];
				if (allB(true, a[0], a[1], a[4])) return icons[Fedge3+3];
			} if (FinLine!=-1) {
				if (allB(true, a[0], a[1])) return icons[FinLine];
				if (allB(true, a[4], a[5])) return icons[FinLine+1];
			} if (Fcorner!=-1) {
				if (allB(true, a[0], a[4])) return icons[Fcorner];
				if (allB(true, a[0], a[5])) return icons[Fcorner+1];
				if (allB(true, a[1], a[5])) return icons[Fcorner+2];
				if (allB(true, a[1], a[4])) return icons[Fcorner+3];
			} if (Fjust1!=-1) {
				if (a[0]) return icons[Fjust1];
				if (a[1]) return icons[Fjust1+1];
				if (a[4]) return icons[Fjust1+2];
				if (a[5]) return icons[Fjust1+3];
			}
			return icons[Falone];
			
		case 3: // South 
			if (Fnotches!=-1) {
				if (allCornerB(true, b[1], b[6], b[7], b[12]) && allCornerB(false, b[0], b[2], b[11], b[13])) return icons[Fnotches];
				
				if (allCornerB(true, b[1], b[6], b[7], b[11], b[12], b[13]) && allCornerB(false, b[0], b[2])) return icons[Fnotches+1];
				if (allCornerB(true, b[1], b[0], b[6], b[7], b[12], b[11]) && allCornerB(false, b[2], b[13])) return icons[Fnotches+2];
				if (allCornerB(true, b[0], b[1], b[2], b[6], b[7], b[12]) && allCornerB(false, b[11], b[13])) return icons[Fnotches+3];
				if (allCornerB(true, b[2], b[1], b[6], b[7], b[12], b[13]) && allCornerB(false, b[0], b[11])) return icons[Fnotches+4]; 
				
				if (allCornerB(true, b[1], b[2], b[6], b[7], b[11], b[12], b[13]) && allCornerB(false, b[0])) return icons[Fnotches+5];
				if (allCornerB(true, b[0], b[1], b[6], b[7], b[11], b[12], b[13]) && allCornerB(false, b[2])) return icons[Fnotches+6];
				if (allCornerB(true, b[0], b[1], b[2], b[6], b[7], b[11], b[12]) && allCornerB(false, b[13])) return icons[Fnotches+7];
				if (allCornerB(true, b[0], b[1], b[2], b[6], b[7], b[12], b[13]) && allCornerB(false, b[11])) return icons[Fnotches+8]; 

				if (allCornerB(true, b[1], b[6]) && allCornerB(false, b[0], b[7], b[12])) return icons[Fnotches+9];
				if (allCornerB(true, b[1], b[7]) && allCornerB(false, b[2], b[6], b[12])) return icons[Fnotches+10];
				if (allCornerB(true, b[7], b[12]) && allCornerB(false, b[1], b[6], b[13])) return icons[Fnotches+11];
				if (allCornerB(true, b[6], b[12]) && allCornerB(false, b[1], b[7], b[11])) return icons[Fnotches+12]; 
				
				if (allCornerB(true, b[1], b[6], b[7], b[12], b[13]) && allCornerB(false, b[0], b[2], b[11])) return icons[Fnotches+13];
				if (allCornerB(true, b[1], b[6], b[7], b[11], b[12]) && allCornerB(false, b[0], b[2], b[13])) return icons[Fnotches+14];
				if (allCornerB(true, b[0], b[1], b[6], b[7], b[12]) && allCornerB(false, b[2], b[11], b[13])) return icons[Fnotches+15];
				if (allCornerB(true, b[1], b[2], b[6], b[7], b[12]) && allCornerB(false, b[0], b[11], b[13])) return icons[Fnotches+16]; 

				if (allCornerB(true, b[0], b[1], b[6], b[7], b[12], b[13]) && allCornerB(false, b[2], b[11])) return icons[Fnotches+17];
				if (allCornerB(true, b[1], b[2], b[6], b[7], b[11], b[12]) && allCornerB(false, b[0], b[13])) return icons[Fnotches+18]; 
				
				if (allCornerB(true, b[1], b[6], b[7]) && allCornerB(false, b[0], b[2], b[12])) return icons[Fnotches+19];
				if (allCornerB(true, b[1], b[7], b[12]) && allCornerB(false, b[2], b[6], b[13])) return icons[Fnotches+20];
				if (allCornerB(true, b[6], b[7], b[12]) && allCornerB(false, b[1], b[11], b[13])) return icons[Fnotches+21];
				if (allCornerB(true, b[1], b[6], b[12]) && allCornerB(false, b[0], b[7], b[11])) return icons[Fnotches+22]; 
				
				if (allCornerB(true, b[1], b[2], b[6], b[7]) && allCornerB(false, b[0], b[12])) return icons[Fnotches+23];
				if (allCornerB(true, b[0], b[1], b[6], b[7]) && allCornerB(false, b[2], b[12])) return icons[Fnotches+24];
				if (allCornerB(true, b[1], b[7], b[12], b[13]) && allCornerB(false, b[2], b[6])) return icons[Fnotches+25];
				if (allCornerB(true, b[1], b[2], b[7], b[12]) && allCornerB(false, b[6], b[13])) return icons[Fnotches+26];
				if (allCornerB(true, b[6], b[7], b[11], b[12]) && allCornerB(false, b[1], b[13])) return icons[Fnotches+27];
				if (allCornerB(true, b[6], b[7], b[12], b[13]) && allCornerB(false, b[1], b[11])) return icons[Fnotches+28];
				if (allCornerB(true, b[0], b[1], b[6], b[12]) && allCornerB(false, b[7], b[11])) return icons[Fnotches+29];
				if (allCornerB(true, b[1], b[6], b[11], b[12]) && allCornerB(false, b[0], b[7])) return icons[Fnotches+30]; 
        	} 
			if ((Fsurrounded!=-1)&&(allB(true, a[0], a[1], a[4], a[5]))) return icons[Fsurrounded];
			if (Fedge3!=-1) {
				if (allB(true, a[0], a[4], a[5])) return icons[Fedge3];
				if (allB(true, a[0], a[1], a[4])) return icons[Fedge3+1];
				if (allB(true, a[1], a[4], a[5])) return icons[Fedge3+2];
				if (allB(true, a[0], a[1], a[5])) return icons[Fedge3+3];
			} if (FinLine!=-1) {
				if (allB(true, a[0], a[1])) return icons[FinLine];
				if (allB(true, a[4], a[5])) return icons[FinLine+1];
			} if (Fcorner!=-1) {
				if (allB(true, a[0], a[5])) return icons[Fcorner];
				if (allB(true, a[0], a[4])) return icons[Fcorner+1];
				if (allB(true, a[1], a[4])) return icons[Fcorner+2];
				if (allB(true, a[1], a[5])) return icons[Fcorner+3];
			} if (Fjust1!=-1) {
				if (a[0]) return icons[Fjust1];
				if (a[1]) return icons[Fjust1+1];
				if (a[5]) return icons[Fjust1+2];
				if (a[4]) return icons[Fjust1+3];
			}
			return icons[Falone];
		case 4: // West
			if (Fnotches!=-1) {
				if (allCornerB(true, b[1], b[4], b[9], b[12]) && allCornerB(false, b[14], b[15], b[16], b[17])) return icons[Fnotches];
				
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[16], b[17]) && allCornerB(false, b[14], b[15])) return icons[Fnotches+1];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[15], b[17]) && allCornerB(false, b[14], b[16])) return icons[Fnotches+2];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[15]) && allCornerB(false, b[16], b[17])) return icons[Fnotches+3];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[16]) && allCornerB(false, b[15], b[17])) return icons[Fnotches+4]; 
				
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[16], b[17]) && allCornerB(false, b[15])) return icons[Fnotches+5];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[15], b[16], b[17]) && allCornerB(false, b[14])) return icons[Fnotches+6];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[15], b[17]) && allCornerB(false, b[16])) return icons[Fnotches+7];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[15], b[16]) && allCornerB(false, b[17])) return icons[Fnotches+8]; 

				if (allCornerB(true, b[1], b[9]) && allCornerB(false, b[4], b[12], b[15])) return icons[Fnotches+9];
				if (allCornerB(true, b[1], b[4]) && allCornerB(false, b[9], b[12], b[14])) return icons[Fnotches+10];
				if (allCornerB(true, b[4], b[12]) && allCornerB(false, b[1], b[9], b[16])) return icons[Fnotches+11];
				if (allCornerB(true, b[9], b[12]) && allCornerB(false, b[1], b[4], b[17])) return icons[Fnotches+12]; 
				
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[16]) && allCornerB(false, b[14], b[15], b[17])) return icons[Fnotches+13];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[17]) && allCornerB(false, b[14], b[15], b[16])) return icons[Fnotches+14];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[15]) && allCornerB(false, b[14], b[16], b[17])) return icons[Fnotches+15];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14]) && allCornerB(false, b[15], b[16], b[17])) return icons[Fnotches+16]; 

				if (allCornerB(true, b[1], b[4], b[9], b[12], b[15], b[16]) && allCornerB(false, b[14], b[17])) return icons[Fnotches+17];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[17]) && allCornerB(false, b[15], b[16])) return icons[Fnotches+18]; 
				
				if (allCornerB(true, b[1], b[4], b[9]) && allCornerB(false, b[14], b[15], b[12])) return icons[Fnotches+19];
				if (allCornerB(true, b[1], b[4], b[12]) && allCornerB(false, b[9], b[14], b[16])) return icons[Fnotches+20];
				if (allCornerB(true, b[4], b[9], b[12]) && allCornerB(false, b[1], b[16], b[17])) return icons[Fnotches+21];
				if (allCornerB(true, b[1], b[9], b[12]) && allCornerB(false, b[4], b[15], b[17])) return icons[Fnotches+22]; 
				
				if (allCornerB(true, b[1], b[4], b[9], b[14]) && allCornerB(false, b[12], b[15])) return icons[Fnotches+23];
				if (allCornerB(true, b[1], b[4], b[9], b[15]) && allCornerB(false, b[12], b[14])) return icons[Fnotches+24];
				if (allCornerB(true, b[1], b[4], b[12], b[16]) && allCornerB(false, b[9], b[14])) return icons[Fnotches+25];
				if (allCornerB(true, b[1], b[4], b[12], b[14]) && allCornerB(false, b[9], b[16])) return icons[Fnotches+26];
				if (allCornerB(true, b[4], b[9], b[12], b[17]) && allCornerB(false, b[1], b[16])) return icons[Fnotches+27];
				if (allCornerB(true, b[4], b[9], b[12], b[16]) && allCornerB(false, b[1], b[17])) return icons[Fnotches+28];
				if (allCornerB(true, b[1], b[9], b[12], b[15]) && allCornerB(false, b[4], b[17])) return icons[Fnotches+29];
				if (allCornerB(true, b[1], b[9], b[12], b[17]) && allCornerB(false, b[4], b[15])) return icons[Fnotches+30]; 
        	}
			if ((Fsurrounded!=-1)&&(allB(true, a[0], a[1], a[2], a[3]))) return icons[Fsurrounded];
			if (Fedge3!=-1) {
				if (allB(true, a[0], a[2], a[3])) return icons[Fedge3];
				if (allB(true, a[0], a[1], a[3])) return icons[Fedge3+1];
				if (allB(true, a[1], a[2], a[3])) return icons[Fedge3+2];
				if (allB(true, a[0], a[1], a[2])) return icons[Fedge3+3];
			} if (FinLine!=-1) {
				if (allB(true, a[0], a[1])) return icons[FinLine];
				if (allB(true, a[2], a[3])) return icons[FinLine+1];
			} if (Fcorner!=-1) {
				if (allB(true, a[0], a[2])) return icons[Fcorner];
				if (allB(true, a[0], a[3])) return icons[Fcorner+1];
				if (allB(true, a[1], a[3])) return icons[Fcorner+2];
				if (allB(true, a[1], a[2])) return icons[Fcorner+3];
			} if (Fjust1!=-1) {
				if (a[0]) return icons[Fjust1];
				if (a[1]) return icons[Fjust1+1];
				if (a[2]) return icons[Fjust1+2];
				if (a[3]) return icons[Fjust1+3];
			}
			return icons[Falone];
		case 5: // East
			if (Fnotches!=-1) {
				if (allCornerB(true, b[1], b[4], b[9], b[12]) && allCornerB(false, b[14], b[15], b[16], b[17])) return icons[Fnotches];
				
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[16], b[17]) && allCornerB(false, b[14], b[15])) return icons[Fnotches+1];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[16]) && allCornerB(false, b[15], b[17])) return icons[Fnotches+2];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[15]) && allCornerB(false, b[16], b[17])) return icons[Fnotches+3];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[15], b[17]) && allCornerB(false, b[14], b[16])) return icons[Fnotches+4]; 
				
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[15], b[16], b[17]) && allCornerB(false, b[14])) return icons[Fnotches+5];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[16], b[17]) && allCornerB(false, b[15])) return icons[Fnotches+6];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[15], b[16]) && allCornerB(false, b[17])) return icons[Fnotches+7];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[15], b[17]) && allCornerB(false, b[16])) return icons[Fnotches+8]; 

				if (allCornerB(true, b[1], b[4]) && allCornerB(false, b[9], b[12], b[14])) return icons[Fnotches+9];
				if (allCornerB(true, b[1], b[9]) && allCornerB(false, b[4], b[12], b[15])) return icons[Fnotches+10];
				if (allCornerB(true, b[9], b[12]) && allCornerB(false, b[1], b[4], b[17])) return icons[Fnotches+11];
				if (allCornerB(true, b[4], b[12]) && allCornerB(false, b[1], b[9], b[16])) return icons[Fnotches+12]; 
				
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[17]) && allCornerB(false, b[14], b[15], b[16])) return icons[Fnotches+13];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[16]) && allCornerB(false, b[14], b[15], b[17])) return icons[Fnotches+14];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14]) && allCornerB(false, b[15], b[16], b[17])) return icons[Fnotches+15];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[15]) && allCornerB(false, b[14], b[16], b[17])) return icons[Fnotches+16]; 

				if (allCornerB(true, b[1], b[4], b[9], b[12], b[14], b[17]) && allCornerB(false, b[15], b[16])) return icons[Fnotches+17];
				if (allCornerB(true, b[1], b[4], b[9], b[12], b[15], b[16]) && allCornerB(false, b[14], b[17])) return icons[Fnotches+18]; 
				
				if (allCornerB(true, b[1], b[4], b[9]) && allCornerB(false, b[14], b[15], b[12])) return icons[Fnotches+19];
				if (allCornerB(true, b[1], b[9], b[12]) && allCornerB(false, b[4], b[15], b[17])) return icons[Fnotches+20];
				if (allCornerB(true, b[4], b[9], b[12]) && allCornerB(false, b[1], b[16], b[17])) return icons[Fnotches+21];
				if (allCornerB(true, b[1], b[4], b[12]) && allCornerB(false, b[9], b[14], b[16])) return icons[Fnotches+22]; 
				
				if (allCornerB(true, b[1], b[4], b[9], b[15]) && allCornerB(false, b[12], b[14])) return icons[Fnotches+23];
				if (allCornerB(true, b[1], b[4], b[9], b[14]) && allCornerB(false, b[12], b[15])) return icons[Fnotches+24];
				if (allCornerB(true, b[1], b[9], b[12], b[17]) && allCornerB(false, b[4], b[15])) return icons[Fnotches+25];
				if (allCornerB(true, b[1], b[9], b[12], b[15]) && allCornerB(false, b[4], b[17])) return icons[Fnotches+26];
				if (allCornerB(true, b[4], b[9], b[12], b[16]) && allCornerB(false, b[1], b[17])) return icons[Fnotches+27];
				if (allCornerB(true, b[4], b[9], b[12], b[17]) && allCornerB(false, b[1], b[16])) return icons[Fnotches+28];
				if (allCornerB(true, b[1], b[4], b[12], b[14]) && allCornerB(false, b[9], b[16])) return icons[Fnotches+29];
				if (allCornerB(true, b[1], b[4], b[12], b[16]) && allCornerB(false, b[9], b[14])) return icons[Fnotches+30]; 
        	}
			if ((Fsurrounded!=-1)&&(allB(true, a[0], a[1], a[2], a[3]))) return icons[Fsurrounded];
			if (Fedge3!=-1) {
				if (allB(true, a[0], a[2], a[3])) return icons[Fedge3];
				if (allB(true, a[0], a[1], a[2])) return icons[Fedge3+1];
				if (allB(true, a[1], a[2], a[3])) return icons[Fedge3+2];
				if (allB(true, a[0], a[1], a[3])) return icons[Fedge3+3];
			} if (FinLine!=-1) {
				if (allB(true, a[0], a[1])) return icons[FinLine];
				if (allB(true, a[2], a[3])) return icons[FinLine+1];
			} if (Fcorner!=-1) {
				if (allB(true, a[0], a[3])) return icons[Fcorner];
				if (allB(true, a[0], a[2])) return icons[Fcorner+1];
				if (allB(true, a[1], a[2])) return icons[Fcorner+2];
				if (allB(true, a[1], a[3])) return icons[Fcorner+3];
			} if (Fjust1!=-1) {
				if (a[0]) return icons[Fjust1];
				if (a[1]) return icons[Fjust1+1];
				if (a[3]) return icons[Fjust1+2];
				if (a[2]) return icons[Fjust1+3];
			}
			return icons[Falone];
		}
        //should never be needed
        return blockIcon;
    }
       
    /**
     * Is the connection allowed always when sides touch or special conditions?
     * Override if needed
     * @param world
     * @param x of this block
     * @param y of this block
     * @param z of this block
     * @param side of this block that is being rendered
     * @return true/false (true is default)
     */
    public boolean connectionAllowed(IBlockAccess world, int x, int y, int z, int side) {
            return true;
    }
   
    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return world.getBlock(x, y, z) == this ? false : super.shouldSideBeRendered(world, x, y, z, side);
    }
       
    private boolean allB(boolean test, boolean... b) {
        for (boolean v:b) {
                if (v!=test) return false;
        }
        return true;
    }
   
    private boolean matchBlock(IBlockAccess world, int x, int y, int z) {
        for (Block b:FblockConnectionAllowed) {
                if (world.getBlock(x, y, z).equals(b)) return true;
        }
        return false;
    }
   
    private boolean[] getB(IBlockAccess world, int x, int y, int z) {
        return new boolean[]{
                matchBlock(world, x, y-1, z),	// Bottom
                matchBlock(world, x, y+1, z),	// Top
                matchBlock(world, x, y, z+1),	// North
                matchBlock(world, x, y, z-1),	// South
                matchBlock(world, x-1, y, z),	// West
                matchBlock(world, x+1, y, z),	// East
        };
    }
    
    private boolean allCornerB(boolean test, boolean... b) {
    	for (boolean v:b) {
    		if (v!=test) return false;
    	}
    	return true;
    }
    
    private boolean[] getCornerB(IBlockAccess world, int x, int y, int z) {
    	return new boolean[]{
    		matchBlock(world, x-1, y+1, z), // Top Left
    		matchBlock(world, x, y+1, z),	// Top Middle
    		matchBlock(world, x+1, y+1, z),	// Top Right
    		matchBlock(world, x-1, y, z+1), // North West
    		matchBlock(world, x, y, z+1),	// North
    		matchBlock(world, x+1, y, z+1),	// North East
    		matchBlock(world, x-1, y, z),	// West
    		matchBlock(world, x+1, y, z),	// East
    		matchBlock(world, x-1, y, z-1), // South West
    		matchBlock(world, x, y, z-1),	// South
    		matchBlock(world, x+1, y, z-1),	// South East
    		matchBlock(world, x-1, y-1, z), // Bottom Left
    		matchBlock(world, x, y-1, z),	// Bottom Middle
    		matchBlock(world, x+1, y-1, z),	// Bottom Right
    		matchBlock(world, x, y+1, z+1), // Top North
    		matchBlock(world, x, y+1, z-1), // Top South
    		matchBlock(world, x, y-1, z+1), // Bottom North
    		matchBlock(world, x, y-1, z-1), // Bottom South
    	};
    }
       
}
