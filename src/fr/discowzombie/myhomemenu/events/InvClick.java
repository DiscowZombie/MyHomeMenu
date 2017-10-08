package fr.discowzombie.myhomemenu.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.earth2me.essentials.IEssentials;

import fr.discowzombie.myhomemenu.MyHomeMenu;

public class InvClick implements Listener {
	
	private MyHomeMenu myHomeMenu;
	
	public InvClick(MyHomeMenu myHomeMenu) {
		this.myHomeMenu = myHomeMenu;
	}

	@EventHandler
	public void onInvClick(InventoryClickEvent e){
		Player player = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();
		if(e.getCurrentItem() == null || current.getType() == Material.AIR || current.getItemMeta() == null || current.getItemMeta().getDisplayName() == null) return;
		
		if(inv.getName().equalsIgnoreCase((myHomeMenu.getConfig().getString("invname") != null ? myHomeMenu.getConfig().getString("invname") : "Homes"))){
			e.setCancelled(true);
			
			String name = null;
			if(myHomeMenu.getConfig().getString("invname") != null){
				name = current.getItemMeta().getDisplayName().replace(myHomeMenu.getConfig().getString("homecolor").toString().replace('&', '§'), "");
			}else{
				name = current.getItemMeta().getDisplayName().replace("§6", "");
			}
			
			IEssentials ess = (IEssentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");
			if(ess != null && ess.getUser(player) != null){
				Location l = null;
				try{
					l = ess.getUser(player).getHome(name);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				if(l != null){
					player.closeInventory();
					player.teleport(l);
				}
			}
		}
	}

}
