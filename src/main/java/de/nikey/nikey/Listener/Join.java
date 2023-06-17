package de.nikey.nikey.Listener;

import de.nikey.nikey.util.Scoreboardutils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.net.InetSocketAddress;

public class Join implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        InetSocketAddress address = event.getPlayer().getAddress();
        for(Player ops : Bukkit.getOnlinePlayers()) {
            if(ops.isOp()) {
                ops.sendMessage(ChatColor.RED + p.getName() +" joined with " + address);
            }
        }
    }
}
