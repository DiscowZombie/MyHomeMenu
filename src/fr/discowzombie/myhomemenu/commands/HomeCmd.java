package fr.discowzombie.myhomemenu.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.earth2me.essentials.IEssentials;

import fr.discowzombie.myhomemenu.MyHomeMenu;
import fr.discowzombie.myhomemenu.utils.ItemBuilder;

public class HomeCmd implements CommandExecutor {

	private MyHomeMenu myHomeMenu;
	
	public HomeCmd(MyHomeMenu myHomeMenu) {
		this.myHomeMenu = myHomeMenu;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			IEssentials ess = (IEssentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");
			List<String> homes = ess.getUser(p).getHomes();
			Integer size = size(homes.size());
			Inventory inv = Bukkit.createInventory(null, size, (myHomeMenu.getConfig().getString("invname") != null ? myHomeMenu.getConfig().getString("invname") : "Homes"));
			for(String s : homes){
				inv.addItem(new ItemBuilder(Material.BOOK).name((myHomeMenu.getConfig().getString("homecolor").toString().replace('&', '§') != null ? myHomeMenu.getConfig().getString("homecolor").toString().replace('&', '§') : "§6") +s).create());
			}
			p.openInventory(inv);
		}
		return true;
	}
	
	private Integer size(int i){
		if(i <= 8){
			return 9;
		}else if(i <= 17){
			return 18;
		}else if(i <= 26){
			return 27;
		}else if(i <= 35){
			return 36;
		}else if(i <= 44){
			return 45;
		}
		return 54;
	}

}
