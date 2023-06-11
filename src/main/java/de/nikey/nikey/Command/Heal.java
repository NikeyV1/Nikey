package de.nikey.nikey.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player ){
            Player p = (Player) sender;
            if (p.isOp() || p.getGameMode() == GameMode.CREATIVE){
                if (args.length >= 1){
                    Player player = Bukkit.getPlayer(args[0]);
                    double maxHealth = player.getMaxHealth();
                    player.setHealth(maxHealth);
                    player.setFoodLevel(40);
                    p.sendMessage(ChatColor.GREEN + "You healed " + player.getName());
                    return true;
                }else {
                    double maxHealth = p.getMaxHealth();
                    p.setHealth(maxHealth);
                    p.setFoodLevel(40);
                    p.sendMessage(ChatColor.GREEN + "Healed!");
                    return true;
                }
            }else {
                p.sendMessage(ChatColor.RED + "You aren't allowed to do that!");
            }
        }
        return false;
    }
}
