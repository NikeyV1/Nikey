package de.nikey.nikey.Listener;

import de.nikey.nikey.Command.Nuke;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class NukeListener implements Listener {
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        if (projectile.getShooter() instanceof Player){
            if (projectile.getType() == EntityType.SNOWBALL){
                if (projectile.getCustomName().equalsIgnoreCase("Nuke")){
                    Location location = event.getHitBlock().getLocation();
                    Player shooter = (Player) projectile.getShooter();
                    if (shooter.getName().equalsIgnoreCase(Nuke.player.getName())){
                        location.getWorld().createExplosion(location,Nuke.map.get(shooter.getName()),false,true);
                    }else {
                        shooter.sendMessage(ChatColor.RED+"Error:Shooter- and Player name aren't the same!");
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemMeta meta = event.getItem().getItemMeta();
        if (event.getItem().getType() == Material.STICK){
            if (meta.getDisplayName().equalsIgnoreCase("Nuke Launcher")){
                Location add = player.getLocation().add(0, 1, 0);
                Snowball t = player.getWorld().spawn(add,Snowball.class);
                t.setVelocity(player.getLocation().getDirection().multiply(1.6));
                t.setShooter(player);
                t.setCustomName("Nuke");
            }
        }
    }
}