package fr.discowzombie.myhomemenu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.discowzombie.myhomemenu.commands.HomeCmd;
import fr.discowzombie.myhomemenu.events.InvClick;

public class MyHomeMenu extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		saveConfig();
		
		Bukkit.getPluginManager().registerEvents(new InvClick(this), this);
		
		getCommand("home").setExecutor(new HomeCmd(this));
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}

}
