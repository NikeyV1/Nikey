package de.nikey.nikey.Capabilities;

import de.nikey.nikey.Nikey;
import de.nikey.nikey.util.Scoreboardutils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class Explosion implements Listener {
    public static HashMap<Player, Integer> map = new HashMap<>();
    public static HashMap<Player, Integer> numb = new HashMap<>();
    public static HashMap<Player, Boolean> sneaking = new HashMap<>();
    int i;
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) throws InterruptedException {
        Player p = event.getPlayer();
        ItemStack item = event.getItem();
        ItemMeta itemMeta = item.getItemMeta();
        if (event.getAction() == Action.RIGHT_CLICK_AIR|event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (item.getType() == Material.NETHERITE_SWORD && itemMeta.getDisplayName().equalsIgnoreCase("Ignition Blade")) {
                itemMeta.setDisplayName("§4Ignition Blade");
                item.setItemMeta(itemMeta);
            }else if (itemMeta.getDisplayName().equalsIgnoreCase("§4Ignition Blade")){
                if (!map.containsKey(p)){
                    if (!p.isSneaking()){
                        sneaking.replace(p,false);
                        p.getWorld().createExplosion(p.getLocation(),2F,false,false);
                        Vector v = p.getLocation().getDirection().multiply(1.4F).setY(0.5);
                        p.setVelocity(v);
                        map.put(p,0);
                        i = 0;
                        numb.replace(p,20);
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                if (map.get(p) < 20){
                                    i++;
                                    map.replace(p,i);
                                    Scoreboardutils.setBaseScoreboard(p);
                                }else {
                                    map.remove(p);
                                    cancel();
                                }
                            }
                        }.runTaskTimer(Nikey.getPlugin(),0L,20);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Nikey.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                p.setInvulnerable(false);
                            }
                        },40);
                    }else if (p.isSneaking()){
                        sneaking.replace(p,true);
                        Location location = p.getLocation();
                        Vector v = p.getLocation().getDirection().multiply(0).setY(+2);
                        p.setVelocity(v);
                        Nikey.nodmg.add(p);
                        map.put(p,0);
                        location.getWorld().createExplosion(p.getLocation(),2.8F,true,true);
                        i=0;
                        numb.replace(p,30);
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                if (map.get(p) < 30){
                                    i++;
                                    map.replace(p,i);
                                    Scoreboardutils.setBaseScoreboard(p);
                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("§l§4" + i));
                                }else {
                                    map.remove(p);
                                    cancel();
                                }
                            }
                        }.runTaskTimer(Nikey.getPlugin(),0L,20);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Nikey.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                Vector s = p.getLocation().getDirection().multiply(0).setY(-4);
                                p.setVelocity(s);
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK,5,1);
                                location.getWorld().createExplosion(location,3.2F,true,true);
                            }
                        },30);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Nikey.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                Nikey.nodmg.remove(p);
                                p.setFireTicks(0);
                                location.getWorld().playSound(location,Sound.BLOCK_BEACON_DEACTIVATE,1,1);
                            }
                        },60);
                    }
                }
            }
        }
    }
}
