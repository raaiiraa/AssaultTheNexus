package com.gmail.lynx7478.anni.enderFurnace.versions.v1_21_R1;

import com.gmail.lynx7478.anni.anniGame.AnniPlayer;
import com.gmail.lynx7478.anni.enderFurnace.api.EnderFurnace;
import com.gmail.lynx7478.anni.enderFurnace.api.IFurnace;
import net.minecraft.core.BlockPos;

public class FurnaceCreator implements com.gmail.lynx7478.anni.enderFurnace.api.FurnaceCreator
{
    @Override
    public IFurnace createFurnace(final AnniPlayer player)
    {
        IFurnace f = new Furnace_v1_21_R1(player.getPlayer());
        if(EnderFurnace.getFurnaceData(player) != null)
            f.load(EnderFurnace.getFurnaceData(player));
        return f;
    }
}
