package com.gmail.lynx7478.anni.anniGame;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.gmail.lynx7478.anni.utils.ItemUtils;
import com.gmail.lynx7478.anni.utils.VersionUtils;

public class SpecificBreaking implements Listener {
	
	private ArrayList<Material> pickaxe;
	private ArrayList<Material> axe;
	private ArrayList<Material> shovel;
	private ArrayList<Material> sword;
	private ArrayList<Material> shears;
	
	public SpecificBreaking() throws ClassNotFoundException
	{
		if(VersionUtils.above13())
		{
			pickaxe = new ArrayList<Material>();
			for(Material a : Material.values())
			{
				if(a.name().contains("IRON_DOOR"))
				{
					pickaxe.add(a);
				}
			}
			ItemUtils.addToList(pickaxe, 
			Material.BRICK,
			Material.BRICK_STAIRS,
			Material.COAL_ORE,
			Material.IRON_ORE,
			Material.GOLD_ORE,
			Material.DIAMOND_ORE,
			Material.EMERALD_ORE,
			Material.REDSTONE_ORE,
			Material.IRON_BLOCK,
			Material.GOLD_BLOCK,
			Material.COAL_BLOCK,
			Material.DIAMOND_BLOCK,
			Material.EMERALD_BLOCK,
			Material.REDSTONE_BLOCK,
			Material.ANVIL
					);
			for(Material a : Material.values())
			{
				if(a.name().contains("STONE"))
				{
					pickaxe.add(a);
				}
			}
			
			axe = new ArrayList<Material>();
			for(Material a : Material.values())
			{
				if(a.name().contains("WOOD") || a.name().contains("FENCE") || a.name().contains("LOG"))
				{
					axe.add(a);
				}
			}
			ItemUtils.addToList(axe,
					Material.LADDER
					
					);
			
			shovel = new ArrayList<Material>();
			ItemUtils.addToList(shovel, 
					Material.DIRT,
					Material.GRASS,
					Material.SOUL_SAND,
					Material.GRAVEL,
					Material.CLAY,
					Material.LEGACY_SOIL,
					Material.SAND,
					Material.LEGACY_MYCEL
					);
			
			sword = new ArrayList<Material>();
			for(Material a : Material.values())
			{
				if(a.name().contains("LEAVES"))
				{
					sword.add(a);
				}
			}
			ItemUtils.addToList(sword, 
					Material.MELON,
					Material.MELON_STEM
					);
			
			shears = new ArrayList<Material>();
			for(Material a : Material.values())
			{
				if(a.name().contains("WOOL"))
				{
					shears.add(a);
				}
			}
		}else
		{
			
			pickaxe = new ArrayList<Material>();
			ItemUtils.addToList(pickaxe, 
			Material.BRICK,
			Material.BRICK_STAIRS,
			Material.COAL_ORE,
			Material.IRON_ORE,
			Material.GOLD_ORE,
			Material.DIAMOND_ORE,
			Material.EMERALD_ORE,
			Material.REDSTONE_ORE,
			Material.IRON_BLOCK,
			Material.GOLD_BLOCK,
			Material.COAL_BLOCK,
			Material.DIAMOND_BLOCK,
			Material.EMERALD_BLOCK,
			Material.REDSTONE_BLOCK,
			Material.ANVIL,
			Material.IRON_DOOR,
			(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "IRON_DOOR_BLOCK")
					);
			for(Material a : Material.values())
			{
				if(a.name().contains("STONE"))
				{
					pickaxe.add(a);
				}
			}
			
			axe = new ArrayList<Material>();
			for(Material a : Material.values())
			{
				if(a.name().contains("WOOD"))
				{
					axe.add(a);
				}
			}
			ItemUtils.addToList(axe, 
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "FENCE"),
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "FENCE_GATE"),
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "LOG"),
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "LOG_2"),
					Material.LADDER
					);
			
			shovel = new ArrayList<Material>();
			ItemUtils.addToList(shovel, 
					Material.DIRT,
					Material.GRASS,
					Material.SOUL_SAND,
					Material.GRAVEL,
					Material.CLAY,
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "SOIL"),
					Material.SAND,
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "MYCEL")
					);
			
			sword = new ArrayList<Material>();
			ItemUtils.addToList(sword, 
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "LEAVES"),
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "LEAVES_2"),
					(Material) Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Material"), "MELON_BLOCK"),
					Material.MELON_STEM
					);
			
			shears = new ArrayList<Material>();
			for(Material a : Material.values())
			{
				if(a.name().contains("WOOL"))
				{
					shears.add(a);
				}
			}
		}
		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e)
	{
		Player p = e.getPlayer();
		if(GameVars.getUseSpecificBreaking())
		{
			if(p.getGameMode() != GameMode.CREATIVE)
			{
				if(this.pickaxe.contains(e.getBlock().getType()))
				{
					if(!p.getItemInHand().getType().name().contains("PICKAXE"))
					{
						e.setCancelled(true);
						return;
					}else
						return;
				}else if(this.axe.contains(e.getBlock().getType()))
				{
					if(!p.getItemInHand().getType().name().contains("AXE"))
					{
						e.setCancelled(true);
						return;
					}else
						return;
				}else if(this.shovel.contains(e.getBlock().getType()))
				{
					if(!p.getItemInHand().getType().name().contains("SPADE"))
					{
						e.setCancelled(true);
						return;
					}else
						return;
				}else if(this.sword.contains(e.getBlock().getType()))
				{
					if(!p.getItemInHand().getType().name().contains("SWORD"))
					{
						e.setCancelled(true);
						return;
					}else
						return;
				}else if(this.shears.contains(e.getBlock().getType()))
				{
					if(!p.getItemInHand().getType().name().contains("SHEARS"))
					{
						e.setCancelled(true);
						return;
					}else
						return;
				}else
					return;
			}
		}
	}

}
