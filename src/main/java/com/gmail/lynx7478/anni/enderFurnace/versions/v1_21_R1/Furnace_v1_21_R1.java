package com.gmail.lynx7478.anni.enderFurnace.versions.v1_21_R1;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R1.block.CraftFurnace;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R1.inventory.CraftItemStack;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.gmail.lynx7478.anni.enderFurnace.api.IFurnace;
import com.gmail.lynx7478.anni.enderFurnace.api.ReflectionUtil;

class Furnace_v1_21_R1 extends AbstractFurnaceBlockEntity implements IFurnace
{
    	private net.minecraft.world.entity.player.Player owningPlayer;

    	public Furnace_v1_21_R1(org.bukkit.entity.Player p)
    	{
            super(BlockEntityType.FURNACE, new BlockPos(0,0,0), null, RecipeType.SMELTING);
            ServerPlayer player = ((CraftPlayer) p).getHandle();
    		this.owningPlayer = player;
    		this.level = player.level();
    		//try
    		//{
    			//ReflectionUtil.setSuperValue(this, "m", "Ender Furnace")

               // this.a(new BlockPosition(0,0,0));
    		//}
    		//catch (Exception e)
    		//{
    		//	e.printStackTrace();
    		//}
    	}


		@Override
    	public boolean canOpen(Player entityhuman)
    	{
    		return true;
    	}

    	public int g() //used to be p()
    	{
    		return 0;
    	}

//    	@Override
//    	public Block q()
//    	{
//    		return Blocks.FURNACE;
//    	}

    	@Override
    	public InventoryHolder getOwner()
    	{
    //		int x = 0;
    //		org.bukkit.block.Block b = this.world.getWorld().getBlockAt(x, 0, 0);
    //		while(b != null && b.getType() != Material.AIR)
    //			b = this.world.getWorld().getBlockAt(++x,0,0);
    //		Furnace furnace = new CraftFurnace(b);
    		org.bukkit.block.Furnace furnace = new CraftFurnace(this.level.getWorld(), this) {
				@Override
				public CraftFurnace copy() {
					return null;
				}

				@Override
				public CraftFurnace copy(Location location) {
					return null;
				}
			};
    		try
    		{
    			ReflectionUtil.setValue(furnace, "furnace", this);
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
    		return furnace;
    	}

        //as of Minecraft 1.8 the bottom slot of a furnace only allows fuel to be put in it.
        //We want to allow any item to be stored in the bottom slot
//        @Override
//        public boolean b(int i, net.minecraft.server.v1_8_R1.ItemStack itemstack)
//        {
//            Bukkit.getLogger().info("This was called");
//            return i != 2;
//        }

    	@Override
    	public void open()
    	{
    		//Bukkit.getLogger().info("Owning players name is "+this.owningPlayer.getName());
    		//this.owningPlayer.openTileEntity(this);//openFurnace(this);
            Bukkit.getLogger().info("Attempted to open for player "+owningPlayer.getName());
            owningPlayer.openMenu(this);
    	}

    	@Override
    	public void tick()
    	{
            try
            {
                this.tick();//this used to be h(); And it is h(); again.
            }
            catch(Throwable t)
            {
                //Do nothing since this seems to be a byproduct of having a furnace that doesnt actually exist in the world
            }
    	}

    	public void setItemStack(int i, ItemStack itemstack)
    	{
    		setItem(i, CraftItemStack.asNMSCopy(itemstack));
    	}

    	public ItemStack getItemStack(int i)
    	{
    		return CraftItemStack.asBukkitCopy(getItem(i));
    	}

    	@Override
    	public FurnaceData getFurnaceData()
    	{
    		return new FurnaceData(this);
    	}

    @Override
    public void load(final com.gmail.lynx7478.anni.enderFurnace.api.FurnaceData data)
    {
        ItemStack[] items = data.getItems();
        for(int x = 0; x < 3; x++)
            this.setItem(x, org.bukkit.craftbukkit.v1_21_R1.inventory.CraftItemStack.asNMSCopy(items[x]));
        this.triggerEvent(0,data.getBurnTime());
        this.triggerEvent(1,data.getTicksForCurrentFuel());
        this.triggerEvent(2,data.getCookTime());
    }

	@Override
	protected Component getDefaultName() {
		return null;
	}

	@Override
	protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
		return null;
	}
}
