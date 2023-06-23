package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Nikey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Satuationstatus implements Listener {
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        HumanEntity entity = event.getEntity();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (Nikey.saturation.contains(p)){
                event.setFoodLevel(40);
                event.setCancelled(true);
            }
        }
    }
}

