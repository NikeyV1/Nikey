package de.nikey.nikey.Command;

import de.nikey.nikey.Nikey;
import de.nikey.nikey.util.Vanishuntils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Vanish implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("This command can be executed only by players.");
            return true;
        }
        final Player player = (Player)sender;
        if (args.length != 0 && args[0].equalsIgnoreCase("reload") && player.isOp()) {
            Nikey.getPlugin().reloadConfig();
            player.sendMessage(Vanishuntils.chat(Nikey.getPlugin().getConfig().getString("reload-message")));
            return true;
        }
        if (player.isOp()) {
            if (!Nikey.getPlugin().getVanishedList().contains(player.getUniqueId())) {
                Nikey.getPlugin().getVanishedList().add(player.getUniqueId());
                player.setCollidable(false);
                for (final Player players : Bukkit.getOnlinePlayers()) {
                    if (!players.hasPermission("simplevanish.bypass")) {
                        players.hidePlayer((Plugin)Nikey.getPlugin(), player);
                    }
                }
                player.sendMessage(Vanishuntils.chat(Nikey.getPlugin().getConfig().getString("vanish-message")));
            }
            else {
                Nikey.getPlugin().getVanishedList().remove(player.getUniqueId());
                player.setCollidable(true);
                for (final Player players : Bukkit.getOnlinePlayers()) {
                    players.showPlayer((Plugin)Nikey.getPlugin(), player);
                }
                player.sendMessage(Vanishuntils.chat(Nikey.getPlugin().getConfig().getString("unvanish-message")));
            }
            return true;
        }
        player.sendMessage(Vanishuntils.chat(Nikey.getPlugin().getConfig().getString("no-access-message")));
        return true;
    }
}
