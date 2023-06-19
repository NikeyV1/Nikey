package de.nikey.nikey.Capabilities;

import de.nikey.nikey.Nikey;
import org.bukkit.*;
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
import org.bukkit.util.Vector;

public class Enderling_Katana implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) throws InterruptedException{
        Action action = event.getAction();
        ItemStack item = event.getItem();
        ItemMeta itemMeta = event.getItem().getItemMeta();
        Player p = event.getPlayer();
        if (action == Action.RIGHT_CLICK_AIR||action == Action.RIGHT_CLICK_BLOCK ){
            if (itemMeta.getDisplayName().equalsIgnoreCase("Enderling Katana")){
                if (item.getType() == Material.NETHERITE_SWORD){
                    Location x = p.getLocation().add(1, 0, 0);
                    Location y = p.getLocation().add(0, 0, 1);
                    Location xx = p.getLocation().add(-1, 0, 0);
                    Location yy = p.getLocation().add(0, 0, -1);
                    Location z = p.getLocation().add(1, 1, 0);
                    Location zz = p.getLocation().add(0, 1, 1);
                    Location zzy = p.getLocation().add(-1, 1, 0);
                    Location zzx = p.getLocation().add(0, 1, -1);
                    Nikey.player.add(p);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 110,1,false,false,false));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 110,1,false,false,false));
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,x,10);
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,xx,10);
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,y,10);
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,yy,10);
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,z,10);
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,zz,10);
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,zzy,10);
                    p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,zzx,10);
                    Bukkit.getScheduler().runTaskLater((Plugin) Nikey.getPlugin(), () -> {
                        try {
                            p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,x,10);
                            p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,xx,10);
                            p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,y,10);
                            p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,yy,10);
                            p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,z,10);
                            p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,zz,10);
                            p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,zzy,10);
                            p.getWorld().spawnParticle(Particle.ELECTRIC_SPARK,zzx,10);
                            Thread.sleep(300);
                            p.setInvulnerable(true);
                            p.getWorld().strikeLightningEffect(x);
                            p.getWorld().strikeLightningEffect(x);
                            p.getWorld().strikeLightningEffect(x);
                            p.getWorld().strikeLightningEffect(x);
                            LightningStrike lightning = p.getLocation().getWorld().spawn(x, LightningStrike.class);
                            LightningStrike lightning1 = p.getLocation().getWorld().spawn(xx, LightningStrike.class);
                            LightningStrike lightning2 = p.getLocation().getWorld().spawn(yy ,LightningStrike.class);
                            LightningStrike lightning3 = p.getLocation().getWorld().spawn(y, LightningStrike.class);
                            lightning.setCustomName("light");
                            lightning1.setCustomName("light");
                            lightning2.setCustomName("light");
                            lightning3.setCustomName("light");
                            Nikey.player.remove(p);
                            Thread.sleep(100);
                            p.getActivePotionEffects().clear();
                            p.getWorld().playSound(p.getLocation(),Sound.ENTITY_WARDEN_SONIC_BOOM,100,1);
                            Vector v = p.getLocation().getDirection().multiply(1.5F).setY(1F);
                            p.setVelocity(v);
                            Thread.sleep(500);
                            p.getWorld().createExplosion(p.getLocation(),2,false,false);
                            p.getWorld().spawnParticle(Particle.FLASH,p.getLocation(),5);
                            Thread.sleep(500);
                            p.getWorld().spawnParticle(Particle.FLASH,p.getLocation(),5);
                            p.getWorld().createExplosion(p.getLocation(),2,false,false);
                            Thread.sleep(500);
                            p.getWorld().spawnParticle(Particle.FLASH,p.getLocation(),5);
                            p.getWorld().createExplosion(p.getLocation(),2,false,false);
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
