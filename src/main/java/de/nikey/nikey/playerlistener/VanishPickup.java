package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Nikey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class VanishPickup implements Listener {
    @EventHandler
    private void PickupItem(final EntityPickupItemEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)e.getEntity();
        if (!(player instanceof Player)) {
            return;
        }
        if (Nikey.getPlugin().getVanishedList().contains(player.getUniqueId())) {
            e.setCancelled(true);
        }
    }
}
