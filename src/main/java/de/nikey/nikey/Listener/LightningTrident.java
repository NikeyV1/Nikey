package de.nikey.nikey.Listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LightningTrident implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity){
            Player player = (Player) event.getDamager();
            LivingEntity livingEntity = (LivingEntity) event.getEntity();
            if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.CHANNELING) && player.getInventory().getItemInMainHand().getType() == Material.TRIDENT){
                player.getWorld().strikeLightning(livingEntity.getLocation());
            }
        }
    }
}
