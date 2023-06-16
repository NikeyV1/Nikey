package de.nikey.nikey.Capabilities;

import de.nikey.nikey.Nikey;
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

public class Explosion implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) throws InterruptedException {
        Player p = event.getPlayer();
        ItemStack item = event.getItem();
        ItemMeta itemMeta = item.getItemMeta();
        if (event.getAction() == Action.RIGHT_CLICK_AIR|event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (item.getType() == Material.NETHERITE_SWORD && itemMeta.getDisplayName().equalsIgnoreCase("Ignition Blade")){
                if (!p.hasCooldown(Material.NETHERITE_SWORD)){
                    if (p.isSneaking()){
                        p.setInvulnerable(true);
                        short durability = item.getDurability();
                        short a = 30;
                        short end = (short) (durability -a);
                        item.setDurability((short) end);
                        p.getWorld().createExplosion(p.getLocation(),2F,false,false);
                        Vector v = p.getLocation().getDirection().multiply(1.4F).setY(0.5);
                        p.setVelocity(v);
                        p.setInvulnerable(false);
                        p.setCooldown(Material.NETHERITE_SWORD,20*20);
                    }else if (!p.isSneaking()){
                        Vector v = p.getLocation().getDirection().multiply(0).setY(+2);
                        p.setVelocity(v);
                        p.setInvulnerable(true);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Nikey.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                Vector s = p.getLocation().getDirection().multiply(0).setY(-2);
                                p.setVelocity(s);
                            }
                        },30);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Nikey.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                p.getWorld().createExplosion(p.getLocation(),3F,true,true);
                                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK,5,1);
                                p.setInvulnerable(false);
                                p.setCooldown(Material.NETHERITE_SWORD,20*60);
                            }
                        },30);
                    }
                }
            }
        }
    }
}
