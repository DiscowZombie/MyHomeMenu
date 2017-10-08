package fr.discowzombie.myhomemenu.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	/**
	 * 
	 */
	/**
	 * @author Mathéo | DiscowZombie
	 *
	 */
	
	private Material mat = null;
	private Integer amount = Integer.valueOf(1);
	private byte data = Byte.valueOf((byte) 0);
	private String name = null;
	private List<String> lore = null;
	private Map<Enchantment, Integer> enchantments = null;
	
	/**
	 * 
	 */
	/**
	 * @param material
	 * @return {@link Void}
	 *
	 */
	public ItemBuilder(Material mat){
		this.mat = mat;
	}
	
	/**
	 * 
	 */
	/**
	 * @param
	 * @return {@link ItemBuilder}
	 *
	 */
	public ItemBuilder amount(Integer amount){
		this.amount = amount;
		return this;
	}
	
	/**
	 * 
	 */
	/**
	 * @param
	 * @return {@link ItemBuilder}
	 *
	 */
	public ItemBuilder data(byte data){
		this.data = data;
		return this;
	}
	
	/**
	 * 
	 */
	/**
	 * @param
	 * @return {@link ItemBuilder}
	 *
	 */
	public ItemBuilder name(String name){
		this.name = name;
		return this;
	}
	
	/**
	 * 
	 */
	/**
	 * @param
	 * @return {@link ItemBuilder}
	 *
	 */
	public ItemBuilder lore(String... strings){
		if(lore == null){
			lore = new ArrayList<>();
		}
		for(String s : strings){
			if(s != null){
				lore.add(s);
			}
		}
		return this;
	}
	
	/**
	 * 
	 */
	/**
	 * @param
	 * @return {@link ItemBuilder}
	 *
	 */
	public ItemBuilder addEnchantment(Enchantment enchantment, Integer level){
		if(enchantments == null){
			enchantments = new HashMap<>();
		}
		if(enchantment != null){
			enchantments.put(enchantment, level);
		}
		return this;
	}
	
	/**
	 * 
	 */
	/**
	 * @return {@link ItemStack}
	 *
	 */
	public ItemStack create(){
		ItemStack is = new ItemStack(mat, amount, data);
		ItemMeta iM = is.getItemMeta();
		if(name != null){
			iM.setDisplayName(name);
		}
		if(lore != null){
			iM.setLore(lore);
		}
		if(enchantments != null){
			for(Entry<Enchantment, Integer> m : enchantments.entrySet()){
				iM.addEnchant(m.getKey(), m.getValue(), true);
			}
		}
		is.setItemMeta(iM);	
		return is;
	}

}

