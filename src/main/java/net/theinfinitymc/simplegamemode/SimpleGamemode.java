package net.theinfinitymc.simplegamemode;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleGamemode extends JavaPlugin{
	
	@Override
	public void onEnable() {
		CommandExecutor executor = new GMCommand();
		for(int i = 0; i <= 3; i++) {
			getCommand(Integer.toString(i)).setExecutor(executor);
		}
	}
	
}