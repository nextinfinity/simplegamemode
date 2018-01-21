package net.theinfinitymc.simplegamemode;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMCommand implements CommandExecutor {

    private static String PREFIX = ChatColor.GOLD+"["+ChatColor.YELLOW+"SimpleGM"+ChatColor.GOLD+"] ";

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        GameMode mode = GameMode.getByValue(Integer.parseInt(commandLabel));
        if(player.hasPermission("simplegm.use")) {
            if (args.length == 0) {
                player.setGameMode(mode);
                player.sendMessage(PREFIX + "Gamemode set to" + mode.name() + "!");
            } else {
                if (player.hasPermission("simplegm.use.others")) {
                    try {
                        Player targetPlayer = player.getServer().getPlayer(args[0]);
                        targetPlayer.setGameMode(mode);
                        player.sendMessage(PREFIX + "Successfully set " + targetPlayer.getName() + "'s gamemode to" + mode.name() + "!");
                        targetPlayer.sendMessage(PREFIX + "Your gamemode has been set to " + mode.name() + "!");
                    } catch (Exception e) {
                        player.sendMessage(PREFIX + ChatColor.RED + "That player is not on the server!");
                    }
                }
            }
        }
        return true;
    }

}
