package com.gmail.lynx7478.anni.enderFurnace.versions.v1_21_R1;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;

class FurnaceData extends com.gmail.lynx7478.anni.enderFurnace.api.FurnaceData
{
	
	private static AbstractFurnaceBlockEntity furnace;
	
    public FurnaceData(Furnace_v1_21_R1 furnace_v1_13_R2)
    {
        super(asBukkitCopy(getStacksAsCollection()));
        FurnaceData.furnace = furnace_v1_13_R2;
    }
    private static org.bukkit.inventory.ItemStack[] asBukkitCopy(ItemStack[] stacks)
    {
        org.bukkit.inventory.ItemStack[] items = new org.bukkit.inventory.ItemStack[stacks.length];
        for(int i = 0; i < items.length; i++)
        {
            items[i] = org.bukkit.craftbukkit.v1_21_R1.inventory.CraftItemStack.asBukkitCopy(stacks[i]);
        }
        return items;
    }
    
    private static ItemStack[] getStacksAsCollection()
    {
    	ItemStack[] stacks = new ItemStack[furnace.getContents().size()];
    	int num = 0;
    	for(ItemStack i : furnace.getContents())
    	{
    		if(num>furnace.getContents().size())
    		{
    			break;
    		}else
    		{
    			stacks[num] = i;
    		}
    	}
    	return stacks;
    }
}
