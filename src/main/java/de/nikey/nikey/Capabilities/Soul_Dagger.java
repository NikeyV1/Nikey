package de.nikey.nikey.Capabilities;

import de.nikey.nikey.util.Scoreboardutils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Random;

public class Soul_Dagger implements Listener {
    public static HashMap<Player,Integer> map = new HashMap<>();
    public Integer i;
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        Random rand = new Random();
        Entity damager = event.getDamager();
        Entity entity = event.getEntity();
        if (damager instanceof Player){
            Player p = (Player) damager;
            ItemStack hand = p.getItemInHand();
            if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Soul Dagger")){
                i = map.get(p);
                if (hand.getType() == Material.DIAMOND_SWORD || hand.getType() == Material.NETHERITE_SWORD){
                    Scoreboardutils.setBaseScoreboard(p);
                    if (i != null){
                        map.put(p,i+1);
                    }else {
                        map.put(p,1);
                    }
                    if (i==12){
                        Random r = new Random();
                        int nint = r.nextInt(4);
                        map.put(p,0);
                        double maxHealth = p.getMaxHealth();
                        p.setHealth(p.getHealth()+nint);
                        Scoreboardutils.setBaseScoreboard(p);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getKiller().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Soul Dagger")){
            Location location = entity.getLocation();
            location.add(0,1,0);
            entity.getWorld().spawnParticle(Particle.SOUL,location,3);
        }
        if (event.getEntity() instanceof Player){
            Player p = (Player) entity;
            Player killer = p.getKiller();
            if (killer.getItemInHand().getType() == Material.NETHERITE_SWORD || killer.getItemInHand().getType() == Material.DIAMOND_SWORD && killer.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Soul Dagger")){
                killer.setHealth(killer.getHealth()+5);
            }
        }
    }
}
