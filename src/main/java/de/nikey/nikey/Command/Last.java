package de.nikey.nikey.Command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Last implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.isOp()){
                ItemStack chance = new ItemStack(Material.TOTEM_OF_UNDYING);
                ItemMeta meta = chance.getItemMeta();
                meta.setDisplayName("Last Chance " + ChatColor.MAGIC+"betrayal");
                chance.setItemMeta(meta);
                p.getInventory().addItem(chance);
            }
        }
        return true;
    }
}
