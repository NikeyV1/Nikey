package de.nikey.nikey.Listener;

import de.nikey.nikey.Nikey;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LastChance implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) throws InterruptedException {
        Action action = event.getAction();
        ItemStack item = event.getItem();
        Player p = event.getPlayer();
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta.getDisplayName().equalsIgnoreCase("Last Chance " + ChatColor.MAGIC+"betrayal")){
            if (action == Action.RIGHT_CLICK_AIR){
                Location loc = p.getLocation();
                World world = p.getWorld();
                world.spawnParticle(Particle.FLAME,p.getLocation(),9);
                world.spawnParticle(Particle.LANDING_LAVA,p.getLocation(),7);
                world.spawnParticle(Particle.SCULK_SOUL,loc,2);
                p.getInventory().getItemInMainHand().setType(Material.AIR);
                Nikey.nomove.add(p);
                Thread.sleep(1000);
                world.strikeLightning(p.getLocation());
                world.strikeLightning(p.getLocation());
                world.strikeLightning(p.getLocation());
                world.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT,10,10);
                world.spawnParticle(Particle.NAUTILUS,loc,2);
                world.createExplosion(loc,1,true,true);
                Thread.sleep(1000);
                world.spawnParticle(Particle.NAUTILUS,loc,2);
                world.createExplosion(loc,1,true,true);
                Thread.sleep(1000);
                world.createExplosion(loc,2,true,true);
                Thread.sleep(1000);
                world.createExplosion(loc,3,true,true);
                Thread.sleep(600);
                world.createExplosion(loc,4,true,true);
                Thread.sleep(500);
                world.createExplosion(loc,5,true,true);
                Thread.sleep(400);
                world.createExplosion(loc,6,true,true);
                Thread.sleep(300);
                world.createExplosion(loc,8,true,true);
                Thread.sleep(200);
                world.createExplosion(loc,10,true,true);
                Thread.sleep(100);
                world.createExplosion(loc,12,true,true);
                Thread.sleep(50);
                world.createExplosion(loc,15,true,true);
                Thread.sleep(50);
                world.createExplosion(loc,20,true,true);
                Nikey.nomove.remove(p);
                Wither wither = world.spawn(loc, Wither.class);
                wither.setMaxHealth(500);
                wither.setArrowCooldown(5);
                wither.setCustomName("Revenge");
                wither.setHealth(500);
                wither.setCustomNameVisible(true);
                wither.setGlowing(true);
                world.setTime(15000);
                Location x = p.getLocation().add(2, 0, 0);
                Location y = p.getLocation().add(0, 0, 2);
                Location xx = p.getLocation().add(-2, 0, 0);
                Location yy = p.getLocation().add(0, 0, -2);
                p.getWorld().spawn(x, LightningStrike.class);
                p.getWorld().spawn(xx, LightningStrike.class);
                p.getWorld().spawn(y, LightningStrike.class);
                p.getWorld().spawn(yy, LightningStrike.class);
                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 1000,1,true,true,true));
                Thread.sleep(200);
                p.setHealth(1);
                world.spawnParticle(Particle.DRAGON_BREATH,loc,12);
                world.spawnParticle(Particle.DRAGON_BREATH,x,10);
                world.spawnParticle(Particle.DRAGON_BREATH,xx,10);
                world.spawnParticle(Particle.DRAGON_BREATH,yy,10);
                world.spawnParticle(Particle.DRAGON_BREATH,y,10);
                world.spawnParticle(Particle.EXPLOSION_HUGE,loc,10);
                for (Player players : Bukkit.getOnlinePlayers()){
                    players.removePassenger(p);
                    wither.attack(players);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        Item item = event.getItemDrop();
        if (item.getItemStack().getType()== Material.TOTEM_OF_UNDYING){
            ItemMeta meta = item.getItemStack().getItemMeta();
            if (meta.getDisplayName().equalsIgnoreCase("Last Chance " + ChatColor.MAGIC+"betrayal")){
                event.setCancelled(true);
                double health = player.getHealth();
                player.setHealth(health-5);
                player.playSound(player.getLocation(),Sound.ENTITY_WARDEN_SONIC_BOOM,1,1);
            }
        }
    }
}
