package net.theinfinitymc.simplegamemode;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleGamemode extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static SimpleGamemode plugin;
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled!");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been enabled!");
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;	
		if(commandLabel.equalsIgnoreCase("0") || commandLabel.equalsIgnoreCase("1") || commandLabel.equalsIgnoreCase("2") || commandLabel.equalsIgnoreCase("3")){
			GameMode mode = GameMode.getByValue(Integer.parseInt(commandLabel));
			if(player.hasPermission("simplegm.use")){				
				if(args.length == 0){
				player.setGameMode(mode);
				sendMessage(player, ChatColor.GOLD + "Gamemode set to Survival!");
			    }else{
			    	if(player.hasPermission("simplegm.use.others")){
			    		try{
			    			Player targetPlayer = player.getServer().getPlayer(args[0]);
			    			targetPlayer.setGameMode(mode);
			    			sendMessage(player, ChatColor.GOLD + "Successfully set " + targetPlayer.getName() + "'s gamemode to Survival!");
			    		}catch(Exception e){
			    			sendMessage(player, ChatColor.RED + "That player is not on the server!");
			    		}		
			    	}
			    }
			}
			return true;
		}
		
		if(commandLabel.equalsIgnoreCase("simplegm")){
			sendMessage(player, ChatColor.AQUA + "SimpleGamemode - Developed by Next Infinity - Version 4.0");
			sendMessage(player, ChatColor.GOLD + "/0 - Changes the player's gamemode to Survival.");
			sendMessage(player, ChatColor.GOLD + "/1 - Changes the player's gamemode to Creative.");
			sendMessage(player, ChatColor.GOLD + "/2 - Changes the player's gamemode to Adventure.");
			sendMessage(player, ChatColor.GOLD + "/3 - Changes the player's gamemode to Spectator.");
			sendMessage(player, ChatColor.GOLD + "Following any command with a player's name changes the mode fot that player.");
			return true;
		}
		return false;		
	}
	
	private void sendMessage(Player p, String m){
		p.sendMessage(ChatColor.GOLD + "[" + ChatColor.YELLOW + "SimpleGM" + ChatColor.GOLD + "]" + m);
	}
	
}