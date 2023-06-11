package de.nikey.nikey.Tabcompleater;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class StatsTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 2){
            list.clear();
            list.add("Invulnerable");
            list.add("Flight");
            list.add("Health");
        }
        if (args.length == 1){
            for (Player player : Bukkit.getOnlinePlayers()){
                list.clear();
                list.add(player.getName());
            }
        }
        return list;
    }
}
