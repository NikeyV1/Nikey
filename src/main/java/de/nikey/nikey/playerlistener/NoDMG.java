package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Nikey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class NoDMG implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player ){
            Player p = (Player) entity;
            if (Nikey.nodmg.contains(p)){
                event.setCancelled(true);
            }
        }
    }
}
