package de.nikey.nikey;

import de.nikey.nikey.Capabilities.*;
import de.nikey.nikey.Command.*;
import de.nikey.nikey.Listener.LastChance;
import de.nikey.nikey.Listener.LightningTrident;
import de.nikey.nikey.Listener.NukeListener;
import de.nikey.nikey.Tabcompleater.StatsTab;
import de.nikey.nikey.hex.HexListener;
import de.nikey.nikey.hex.hex;
import de.nikey.nikey.playerlistener.*;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public final class Nikey extends JavaPlugin {
    private static Nikey plugin;
    public static ArrayList<Player> player = new ArrayList<>();
    public static ArrayList<Player> nomove = new ArrayList<>();
    public static ArrayList<Player> nodmg = new ArrayList<>();

    public Set<UUID> vanishedList;

    public void SimpleVanish() {
        this.vanishedList = new HashSet<UUID>();
    }
    public Set<UUID> getVanishedList() {
        return this.vanishedList;
    }

    @Override
    public void onEnable() {
        //Vanish
        this.saveDefaultConfig();
        new BukkitRunnable() {
            public void run() {
                for (final Player p : Bukkit.getOnlinePlayers()) {
                    if (Nikey.this.vanishedList.contains(p.getUniqueId())) {
                        final String message = Nikey.this.getConfig().getString("action-bar-message");
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§2" + message));
                    }
                }
            }
        }.runTaskTimer((Plugin)this, 0L, 20L);

        //Listener
        plugin = this;
        PluginManager plM = Bukkit.getPluginManager();
        plM.registerEvents(new Explosion(),this);
        plM.registerEvents(new Enderling_Katana(),this);
        plM.registerEvents(new Move(),this);
        plM.registerEvents(new NukeListener(),this);
        plM.registerEvents(new HexListener(),this);
        plM.registerEvents(new LastChance(),this);
        plM.registerEvents(new nomove(),this);
        plM.registerEvents(new Eclipse(),this);
        plM.registerEvents(new Netherinferno(),this);
        plM.registerEvents(new Death(),this);
        plM.registerEvents(new Frostnova(),this);
        plM.registerEvents(new lightning(),this);
        plM.registerEvents(new Soul_Dagger(),this);
        plM.registerEvents(new Join(), this);
        plM.registerEvents(new NoDMG(),this);
        plM.registerEvents(new VanishPickup(),this);
        plM.registerEvents(new LightningTrident(),this);

        //Commands
        getCommand("heal").setExecutor(new Heal());
        getCommand("stats").setExecutor(new Stats());
        getCommand("stats").setTabCompleter(new StatsTab());
        getCommand("crash").setExecutor(new Crash());
        getCommand("nuke").setExecutor(new Nuke());
        getCommand("hex").setExecutor(new hex());
        getCommand("kit").setExecutor(new Stats.Kit());
        getCommand("kit").setTabCompleter(new Stats.Kit());
        getCommand("repair").setExecutor(new Repair());
        getCommand("chance").setExecutor(new Last());
        getCommand("try").setExecutor(new Try());
        getCommand("souldagger").setExecutor(new soul_dagger());
        getCommand("vanish").setExecutor(new Vanish());
        System.out.println("Plugin Done Loading");
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin stopped");
    }
    public static Nikey getPlugin() {
        return plugin;
    }
}
