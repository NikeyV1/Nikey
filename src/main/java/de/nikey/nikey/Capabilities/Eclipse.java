package de.nikey.nikey.Capabilities;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Eclipse implements Listener {
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) throws InterruptedException {
        Player p = event.getPlayer();
        Entity entity = event.getRightClicked();
        ItemStack item = p.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        if (meta.getDisplayName().equalsIgnoreCase("Eclipse")){
            if (item.getType() == Material.NETHERITE_SWORD){
                if (entity instanceof Player){
                    Player player = (Player) entity;
                    if (!p.hasCooldown(Material.NETHERITE_SWORD)){
                        player.setFireTicks(20*10);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,20*20 ,2,false,false,false));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20*20 ,2,false,false,false));
                        double scale = player.getHealthScale();
                        player.setHealthScale(15);
                        player.damage(2);
                        double health = p.getHealth();
                        p.setHealth(health+2);
                        //Colldown
                        p.setCooldown(Material.NETHERITE_SWORD,20*60);
                        //reset
                        Thread.sleep(25000);
                        player.setHealthScale(scale);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Player p = event.getPlayer();
        Action action = event.getAction();
        ItemMeta meta = item.getItemMeta();
        if (item.getType() == Material.NETHERITE_SWORD){
            if (action == Action.RIGHT_CLICK_AIR){
                if (meta.getDisplayName().equalsIgnoreCase("Eclipse")){
                    for (Entity player : p.getNearbyEntities(80.0D, 8.0D, 80.0D)){
                        if (player instanceof Player){
                            Player pl = (Player) player;
                            int dur = 20*30;
                            if (!p.hasCooldown(Material.NETHERITE_SWORD)){
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,dur ,1,false,false,false));
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,dur ,2,false,false,false));
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,dur ,1,false,false,false));
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,dur ,1,false,false,false));
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,dur ,1,false,false,false));

                                p.setCooldown(Material.NETHERITE_SWORD,20*120);
                            }
                        }
                    }
                }
            }else if (action == Action.RIGHT_CLICK_BLOCK){
                if (meta.getDisplayName().equalsIgnoreCase("Eclipse")){
                    for (Entity player : p.getNearbyEntities(50.0D, 4.0D, 50.0D)){
                        if (player instanceof Player){
                            Player pl = (Player) player;
                            int dur = 20*30;
                            if (!p.hasCooldown(Material.NETHERITE_SWORD)){
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,dur ,1,false,false,false));
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,dur ,2,false,false,false));
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,dur ,1,false,false,false));
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,dur ,1,false,false,false));
                                pl.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,dur ,1,false,false,false));

                                p.setCooldown(Material.NETHERITE_SWORD,20*120);
                            }
                        }
                    }
                }
            }
        }
    }
}
