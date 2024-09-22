package com.gmail.lynx7478.anni.utils;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

public class Potion
{
    private PotionType type;
    private int level;
    private boolean throwable;
    private boolean extended;

    private ItemStack item;

    public Potion(PotionType type, boolean throwable)
    {
        this.type = type;
        this.level = level;
        this.throwable = throwable;
        this.extended = extended;

        String sType=type.toString();

        if(throwable)
        {
            this.item = new ItemStack(Material.SPLASH_POTION);
        }else
        {
            this.item = new ItemStack(Material.POTION);
        }
        PotionMeta iM = (PotionMeta) item.getItemMeta();
        iM.setBasePotionType(type);
        item.setItemMeta(iM);
    }

    public ItemStack toItemStack(int i)
    {
        item.setAmount(i);
        return item;
    }


}
