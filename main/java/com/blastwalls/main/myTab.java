package com.blastwalls.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class myTab extends CreativeTabs {

	public myTab(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Items.gunpowder;
	}

}
