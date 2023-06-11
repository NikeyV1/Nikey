package de.nikey.nikey.Command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Nuke implements CommandExecutor , Listener {

    public static HashMap<String,Integer> map = new HashMap<>();
    public int i;
    public static Player player;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            player = (Player) sender;
            if (player.isOp()){
                if (args.length == 1){
                    i = Integer.parseInt(args[0]);
                    if (map.containsKey(player.getName())){
                        map.replace(player.getName(),i);
                    }else {
                        map.put(player.getName(),i);
                    }
                    ItemStack snowball = new ItemStack(Material.STICK);
                    ItemMeta meta = snowball.getItemMeta();
                    meta.setDisplayName("Nuke Launcher");
                    snowball.setItemMeta(meta);
                    player.getInventory().addItem(snowball);
                    player.sendMessage(ChatColor.AQUA+"Nuke Launcher received, with power: " +map.get(player.getName()));
                }else if (args.length == 2){
                    if (args[1].equalsIgnoreCase("here")){
                        i = Integer.parseInt(args[0]);
                        player.getWorld().createExplosion(player.getLocation(),i,false,true);
                    }
                }else {
                    player.sendMessage(ChatColor.RED+ "That doesn't work like so!");
                }
            }
        }
        return true;
    }
}
