package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Capabilities.Netherinferno;
import de.nikey.nikey.Nikey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Netherinferno.map.remove(player);
        Nikey.nomove.remove(player);
        Nikey.player.remove(player);
    }
}
