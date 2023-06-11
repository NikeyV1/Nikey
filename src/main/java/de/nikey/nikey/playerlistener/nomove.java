package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Nikey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class nomove implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (Nikey.nomove.contains(p)){
            event.setCancelled(true);
        }
    }
}
