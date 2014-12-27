package org.jamescraft.simplegamemode;

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
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;	
		if(commandLabel.equalsIgnoreCase("0")){
			if(player.hasPermission("simplegm.use")){				
			if(args.length > 1){
				return false;
			}
			if(args.length == 0){
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.GOLD + "Gamemode set to Survival!");
			    }else if(args.length == 1){
			    	if(player.hasPermission("simplegm.use.others")){
			    		try{
			    			Player targetPlayer = player.getServer().getPlayer(args[0]);
			    			targetPlayer.setGameMode(GameMode.SPECTATOR);
			    			player.sendMessage(ChatColor.GOLD + "Successfully set " + targetPlayer.getName() + "'s gamemode to Survival!");
			    		}catch(Exception e){
			    			player.sendMessage(ChatColor.RED + "That player is not on the server!");
			    		}		
			    	}
			    }
			}
			return true;
		}
		
		if(commandLabel.equalsIgnoreCase("1")){
			if(player.hasPermission("simplegm.use")){
				if(args.length > 1){
					return false;
				}
				if(args.length == 0){
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.GOLD + "Gamemode set to Creative!");
				}else if(args.length == 1){
			    	if(player.hasPermission("simplegm.use.others")){					
			    		try{
			    			Player targetPlayer = player.getServer().getPlayer(args[0]);
			    			targetPlayer.setGameMode(GameMode.SPECTATOR);
			    			player.sendMessage(ChatColor.GOLD + "Successfully set " + targetPlayer.getName() + "'s gamemode to Creative!");
			    		}catch(Exception e){
			    			player.sendMessage(ChatColor.RED + "That player is not on the server!");
			    		}
			    	}
				}
			}
			return true;
		}
		
		if(commandLabel.equalsIgnoreCase("2")){
			if(player.hasPermission("simplegm.use")){
				if(args.length > 1){
					return false;
				}
				if(args.length == 0){
				player.setGameMode(GameMode.ADVENTURE);
				player.sendMessage(ChatColor.GOLD + "Gamemode set to Adventure!");
				}else if(args.length == 1){
			    	if(player.hasPermission("simplegm.use.others")){					
			    		try{
			    			Player targetPlayer = player.getServer().getPlayer(args[0]);
			    			targetPlayer.setGameMode(GameMode.SPECTATOR);
			    			player.sendMessage(ChatColor.GOLD + "Successfully set " + targetPlayer.getName() + "'s gamemode to Adventure!");
			    		}catch(Exception e){
			    			player.sendMessage(ChatColor.RED + "That player is not on the server!");
			    		}
			    	}
				}
			}
			return true;
		}
		
		if(commandLabel.equalsIgnoreCase("3")){
			if(player.hasPermission("simplegm.use")){
				if(args.length > 1){
					return false;
				}
				if(args.length == 0){
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage(ChatColor.GOLD + "Gamemode set to Spectator!");
				}else if(args.length == 1){
			    	if(player.hasPermission("simplegm.use.others")){
			    		try{
			    			Player targetPlayer = player.getServer().getPlayer(args[0]);
			    			targetPlayer.setGameMode(GameMode.SPECTATOR);
			    			player.sendMessage(ChatColor.GOLD + "Successfully set " + targetPlayer.getName() + "'s gamemode to Spectator!");
			    		}catch(Exception e){
			    			player.sendMessage(ChatColor.RED + "That player is not on the server!");
			    		}
			    	}
				}
			}
			return true;
		}
		
		if(commandLabel.equalsIgnoreCase("simplegm")){
			if(player.hasPermission("simplegm.info")){
				if(args.length != 0){
					return false;
				}
				player.sendMessage(ChatColor.AQUA + "SimpleGamemode - Developed by Next Infinity - Version 3.0");
				player.sendMessage(ChatColor.GOLD + "/0 - Changes the player's gamemode to Survival.");
				player.sendMessage(ChatColor.GOLD + "/1 - Changes the player's gamemode to Creative.");
				player.sendMessage(ChatColor.GOLD + "/2 - Changes the player's gamemode to Adventure.");
				player.sendMessage(ChatColor.GOLD + "/3 - Changes the player's gamemode to Spectator.");
			}
			return true;
		}

		return false;
			
			
		}
		
		
	
	}

	

	
	
	
	

