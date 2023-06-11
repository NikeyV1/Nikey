package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Nikey;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class lightning implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity entity = event.getEntity();
        if (damager.getType() == EntityType.LIGHTNING){
            Random random = new Random();
            int n = random.nextInt(10);
            if (n == 3){
                if (entity instanceof Player){
                    Player player = (Player) entity;
                    Nikey.nomove.add(player);
                    player.sendMessage("&cThe lightning stunned you!");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Nikey.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            Nikey.nomove.remove(player);
                        }
                    },20*4);
                }
            }
        }
    }
}
