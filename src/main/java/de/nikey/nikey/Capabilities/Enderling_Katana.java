package de.nikey.nikey.Capabilities;

import de.nikey.nikey.Nikey;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Enderling_Katana implements Listener {
    public int i;
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) throws InterruptedException{
        Action action = event.getAction();
        ItemStack item = event.getItem();
        ItemMeta itemMeta = event.getItem().getItemMeta();
        Player p = event.getPlayer();
        if (action == Action.RIGHT_CLICK_AIR||action == Action.RIGHT_CLICK_BLOCK ){
            if (itemMeta.getDisplayName().equalsIgnoreCase("Enderling Katana")){
                if (item.getType() == Material.NETHERITE_SWORD){

                    Nikey.player.add(p);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 110,1,false,false,false));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 110,1,false,false,false));
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,p.getLocation(),10);
                    Bukkit.getScheduler().runTaskLater((Plugin) Nikey.getPlugin(), () -> {
                        try {
                            p.setInvulnerable(true);
                            for (Entity entity : p.getNearbyEntities(10,10,10)){
                                Location loc = entity.getLocation();
                                entity.setGlowing(true);
                                i=0;
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        if (i <10){
                                            i++;
                                            entity.setGlowing(false);
                                            entity.getWorld().strikeLightning(loc);
                                        }else {
                                            cancel();
                                        }
                                    }
                                }.runTaskTimer(Nikey.getPlugin(),0L,4L);
                            }
                            Nikey.player.remove(p);
                            Thread.sleep(100);
                            p.getActivePotionEffects().clear();
                            p.getWorld().playSound(p.getLocation(),Sound.ENTITY_WARDEN_SONIC_BOOM,100,1);
                            Vector v = p.getLocation().getDirection().multiply(1.5F).setY(1F);
                            p.setVelocity(v);
                            Thread.sleep(500);
                            Vector s = p.getLocation().getDirection().multiply(0).setY(-1.5F);
                            //p.setVelocity(s);
                            Thread.sleep(100);
                            p.setInvulnerable(false);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }, 20*5);
                }
            }

        }
    }
}
