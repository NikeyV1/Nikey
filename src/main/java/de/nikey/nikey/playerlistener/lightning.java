package de.nikey.nikey.playerlistener;

import de.nikey.nikey.Nikey;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.weather.LightningStrikeEvent;

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
                    if (damager.getCustomName().equalsIgnoreCase("light")){
                        player.damage(6,damager);
                    }
                    Nikey.nomove.add(player);
                    player.sendMessage(ChatColor.YELLOW+ "The lightning stunned you!");
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

    @EventHandler
    public void onLightningStrike(LightningStrikeEvent event) {
        LightningStrike lightning = event.getLightning();
        if (lightning.getCustomName().equalsIgnoreCase("light")){
            for (Entity players:lightning.getNearbyEntities(5,5,5)){
                if (players instanceof Player){
                    Player player = (Player) players;
                    player.damage(10);
                    player.sendMessage("ttt");
                }
            }
        }
    }
}
