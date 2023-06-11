package de.nikey.nikey.Capabilities;

import de.nikey.nikey.Nikey;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Frostnova implements Listener {
    private int time;
    public static ArrayList<Player> notp = new ArrayList<>();
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();
        ItemMeta meta = item.getItemMeta();
        if (action == Action.RIGHT_CLICK_AIR && item.getType() == Material.AMETHYST_CLUSTER && meta.getDisplayName().equalsIgnoreCase( "Frostnova")){
            for (Entity e : p.getLocation().getWorld().getNearbyEntities(p.getLocation(),80,60,80)){
                if (e instanceof Player){
                    if (!p.hasCooldown(Material.AMETHYST_CLUSTER)){
                        Player player = (Player) e;
                        notp.add(player);
                        time = 0;
                        p.setCooldown(Material.AMETHYST_CLUSTER,20*25);
                        BukkitRunnable runnable = new BukkitRunnable() {
                            @Override
                            public void run() {
                                if (time == 25){
                                    cancel();
                                    notp.remove(player);
                                }else {
                                    time++;
                                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("§l§e" + time));
                                }
                            }
                        };
                        runnable.runTaskTimer(Nikey.getPlugin(),0,20);
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
