package de.nikey.nikey.Command;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Repair implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.isOp()){
                PlayerInventory inv = p.getInventory();
                ItemStack helmet = inv.getHelmet();
                ItemStack leggings = inv.getLeggings();
                ItemStack chestplate = inv.getChestplate();
                ItemStack boots = inv.getBoots();
                ItemStack hand = inv.getItemInHand();
                helmet.setDurability((short) 0);
                leggings.setDurability((short) 0);
                chestplate.setDurability((short) 0);
                boots.setDurability((short) 0);
                hand.setDurability((short) 0);
            }else if (p.getGameMode() == GameMode.CREATIVE){
                PlayerInventory inv = p.getInventory();
                ItemStack helmet = inv.getHelmet();
                ItemStack leggings = inv.getLeggings();
                ItemStack chestplate = inv.getChestplate();
                ItemStack boots = inv.getBoots();
                ItemStack hand = inv.getItemInHand();
                helmet.setDurability((short) 0);
                leggings.setDurability((short) 0);
                chestplate.setDurability((short) 0);
                boots.setDurability((short) 0);
                hand.setDurability((short) 0);
            }else {
                p.sendMessage("§cThis Command doesn't exist!");
            }
        }
        return true;
    }
}
