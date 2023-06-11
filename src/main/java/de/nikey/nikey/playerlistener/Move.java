package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Nikey;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.io.StringReader;

public class Move implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (Nikey.player.contains(p)){
            Location from = event.getFrom();
            Location to = event.getTo();
            double x = from.getX();
            double z = from.getZ();
            double xx = to.getX();
            double zz = to.getZ();
            if (x != xx||z !=zz){
                event.setCancelled(true);
            }
        }
    }
}
