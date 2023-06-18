package de.nikey.nikey.Capabilities;

import de.nikey.nikey.Nikey;
import de.nikey.nikey.util.Scoreboardutils;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class Frostnova implements Listener {
    public static HashMap<Player, Integer> map = new HashMap<>();
    private int time;
    private int i;
    public static ArrayList<Player> notp = new ArrayList<>();
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();
        ItemMeta meta = item.getItemMeta();
        if (action == Action.RIGHT_CLICK_AIR && item.getType() == Material.AMETHYST_CLUSTER && meta.getDisplayName().equalsIgnoreCase( "Frostnova")) {
            meta.setDisplayName("§1Frostnova");
            item.setItemMeta(meta);
        }else if (meta.getDisplayName().equalsIgnoreCase("§1Frostnova")){
            for (Entity e : p.getLocation().getWorld().getNearbyEntities(p.getLocation(),80,60,80)){
                if (e instanceof Player){
                    if (!map.containsKey(p)){
                        Player player = (Player) e;
                        notp.add(player);
                        p.spawnParticle(Particle.SNOWFLAKE,p.getLocation().add(0,1,0),4);
                        time = 0;
                        map.put(p,0);
                        BukkitRunnable runnable= new BukkitRunnable() {
                            @Override
                            public void run() {
                                if (map.get(p)==22){
                                    notp.remove(p);
                                }
                                if (map.get(p) < 30){
                                    time++;
                                    map.replace(p,time);
                                    Scoreboardutils.setBaseScoreboard(p);
                                }else {
                                    cancel();
                                    map.remove(p);
                                }
                            }
                        };
                        runnable.runTaskTimer(Nikey.getPlugin(),0,20);
                        i=0;
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                if (i == 22){
                                    cancel();
                                    i=0;
                                }else {
                                    i++;
                                    for (Entity projectile : p.getLocation().getWorld().getNearbyEntities(p.getLocation(),30,20,30)){
                                        if (projectile instanceof Arrow){
                                            projectile.remove();
                                        } else if (projectile instanceof WitherSkull) {
                                            projectile.remove();
                                        } else if (projectile instanceof SpectralArrow) {
                                            projectile.remove();
                                        }else if (projectile instanceof Snowball) {
                                            projectile.remove();
                                        }
                                    }
                                }
                            }
                        }.runTaskTimer(Nikey.getPlugin(),0L,10);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        if (notp.contains(player)){
            event.setCancelled(true);
        }
    }
}