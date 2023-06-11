package de.nikey.nikey.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Try implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 2){
                if (args[0].equalsIgnoreCase("totem")){
                    int a = Integer.parseInt(args[1]);
                    a = a *10;
                    double health = p.getHealth();
                    try {
                        Thread.sleep(a);
                        p.damage(p.getHealth() + 1);
                        p.sendMessage("0");
                        p.damage(p.getHealth() + 1);
                        Thread.sleep(a);
                        p.damage(health);
                        p.sendMessage("1");
                        Thread.sleep(a);
                        p.damage(p.getHealth() + 1);
                        p.sendMessage("2");
                        Thread.sleep(a);
                        p.damage(p.getHealth() + 1);
                        Thread.sleep(a);
                        p.damage(p.getHealth() + 1);
                        Thread.sleep(a);
                        p.damage(p.getHealth() + 1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return true;
    }
}
