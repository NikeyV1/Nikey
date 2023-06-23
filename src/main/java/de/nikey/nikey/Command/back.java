package de.nikey.nikey.Command;

import de.nikey.nikey.Nikey;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class back implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("back")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "This command can be only made by players!");
                return true;
            }
            if (!sender.isOp()) {
                sender.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
                return true;
            }
            final Player p = (Player)sender;
            if (args.length == 0) {
                if (Nikey.location.get(p) != null){
                    Location location = Nikey.location.get(p);
                    p.teleport(location);
                }else {
                    p.sendMessage(ChatColor.RED + "You don't have a last location!");
                }
                return true;
            }

        }
        return true;
    }
}
