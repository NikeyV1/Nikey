package de.nikey.nikey.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class Crash implements CommandExecutor , Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp()) {
                if (args.length == 0) {
                    p.getWorld().createExplosion(p.getLocation(), 1000F, true, true);
                    p.getWorld().createExplosion(p.getLocation(), 1000F, true, true);
                    p.getWorld().createExplosion(p.getLocation(), 1000F, true, true);
                    p.getWorld().createExplosion(p.getLocation(), 1000F, true, true);
                } else if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target == null){
                        p.sendMessage(ChatColor.RED+ "Error: No target found");
                    }else {
                        crash(target);
                        try {
                            Thread.sleep(100);
                            cancel(target);
                            Thread.sleep(100);
                            crash(target);
                            Thread.sleep(100);
                            cancel(target);
                            Thread.sleep(100);
                            crash(target);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }else {
                    p.sendMessage(ChatColor.RED+ "That doesn't work like so!");
                }
            }else {
                p.sendMessage("§cThis Command doesn't exist");
            }
        }return true;
    }

    public static void crash(Player target) {
        target.setHealthScale(900000);
    }
    public static void cancel(Player target){
        target.setHealthScale(9000);
    }
}
