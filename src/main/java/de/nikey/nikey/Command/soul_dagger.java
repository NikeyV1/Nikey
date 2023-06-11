package de.nikey.nikey.Command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class soul_dagger implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.isOp()){
                ItemStack dagger = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta meta = dagger.getItemMeta();
                meta.setDisplayName(ChatColor.DARK_AQUA + "Soul Dagger");
                dagger.setItemMeta(meta);
                p.getInventory().addItem(dagger);
            }
        }
        return true;
    }
}
