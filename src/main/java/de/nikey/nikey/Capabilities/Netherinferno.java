package de.nikey.nikey.Capabilities;

import de.nikey.nikey.Nikey;
import de.nikey.nikey.util.Scoreboardutils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Set;

public class Netherinferno implements Listener {
    public static Boolean red;
    public static HashMap<Player, Integer> map = new HashMap<>();
    int i;
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        ItemMeta meta = p.getItemInHand().getItemMeta();
        String s = meta.getDisplayName();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (s.equalsIgnoreCase( ChatColor.RED +"Inferno")){
                if (p.isSneaking()){
                    meta.setDisplayName(ChatColor.AQUA + "Inferno");
                    p.getItemInHand().setItemMeta(meta);
                }else {
                    if (!map.containsKey(p)){
                        red = true;
                        Fireball fireball = p.getWorld().spawn(p.getEyeLocation(),Fireball.class);
                        fireball.setVelocity(p.getLocation().getDirection().multiply(1.1));
                        fireball.setShooter(p);
                        fireball.setYield(5F);
                        map.put(p,0);
                        i = 0;
                        Scoreboardutils.setBaseScoreboard(p);
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                if (!fireball.isDead()){
                                    fireball.getWorld().spawnParticle(Particle.FLAME,fireball.getLocation(),3);
                                }else {
                                    cancel();
                                }
                            }
                        }.runTaskTimer(Nikey.getPlugin(),0L,2L);
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                Scoreboardutils.setBaseScoreboard(p);
                                i++;
                                if (map.get(p) < 40){
                                    map.replace(p,i);
                                }else {
                                    i=0;
                                    map.remove(p);
                                    cancel();
                                }
                            }
                        }.runTaskTimer(Nikey.getPlugin(),0L,20);
                    }
                }
            } else if (s.equalsIgnoreCase( ChatColor.AQUA + "Inferno")) {
                if (p.isSneaking()){
                    meta.setDisplayName(ChatColor.RED + "Inferno");
                    p.getItemInHand().setItemMeta(meta);
                }else {
                    if (!map.containsKey(p)){
                        red = false;
                        Block b = p.getTargetBlock((Set)null, 8);
                        Location loc = new Location(b.getWorld(), (double)b.getX(), (double)b.getY(), (double)b.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
                        p.teleport(loc);
                        p.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                        map.put(p,0);
                        i=0;
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                i++;
                                Scoreboardutils.setBaseScoreboard(p);
                                if (map.get(p) < 8){
                                    map.replace(p,i);
                                }else {
                                    map.replace(p,9);
                                    i=0;
                                    cancel();
                                    map.remove(p);
                                    Scoreboardutils.setBaseScoreboard(p);
                                }
                            }
                        }.runTaskTimer(Nikey.getPlugin(),0L,20);
                    }
                }
            }else if (s.equalsIgnoreCase("Inferno")){
                meta.setDisplayName(ChatColor.RED + "Inferno");
                p.getItemInHand().setItemMeta(meta);
            }else {
            }
        }
    }

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        Player p = event.getPlayer();
        Entity entity = event.getRightClicked();
        if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase( ChatColor.AQUA+ "Inferno")){
            if (!map.containsKey(p) && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Inferno")){
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5,0,true,true,true));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20*3,0,true,true,true));
                entity.setFreezeTicks(20*4);
            }else if (!map.containsKey(p) && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Inferno")){
                entity.setFireTicks(20*8);
                if (event instanceof Player){
                    Player player = (Player) entity;
                    player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                }
            }
        }
    }
}
