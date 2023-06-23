package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Nikey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class backcmd implements Listener {
    @EventHandler
    public void onDeath(final PlayerDeathEvent event) {
        final Player p = event.getEntity();
        if (p.hasPermission("back.back")) {
            if (Nikey.location.get(p) != null){
                Nikey.location.replace(p, p.getLocation());
            }else {
                Nikey.location.put(p, p.getLocation());
            }
        }
    }
}
