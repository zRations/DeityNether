package com.imdeity.DeityKingdomsDev.DeityNether.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.imdeity.DeityKingdomsDev.DeityNether.DeityNether;


public class PigmanListener implements Listener {
	private final DeityNether plugin;
	Entity entity;
	int random;
	int chance = DeityNether.PIGMAN_DROP_GOLD_CHANCE;
	int amountDropped;
	ItemStack drops;
	ItemStack newDrop;
	World world;
	String s;
	
	public PigmanListener(DeityNether plugin){
		this.plugin = plugin;
	}

	public void onPigmanDeath(EntityDeathEvent event){
		newDrop = new ItemStack(Material.GOLD_INGOT, 1);
		entity = event.getEntity();
		world = entity.getWorld();
		s = world.getName();
		drops = (ItemStack) event.getDrops();
		amountDropped = drops.getAmount();
		if(entity instanceof PigZombie){
			random = (int)(Math.random()*(100 - chance + 1) + chance);
			if(random < chance){
					Bukkit.getServer().getWorld(s).dropItem(entity.getLocation(), newDrop);
					event.getDrops().notifyAll();
			}
		}
		
	}

}
