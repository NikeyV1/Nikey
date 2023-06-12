package de.nikey.nikey;

import de.nikey.nikey.Capabilities.*;
import de.nikey.nikey.Command.*;
import de.nikey.nikey.Listener.Join;
import de.nikey.nikey.Listener.LastChance;
import de.nikey.nikey.Listener.NukeListener;
import de.nikey.nikey.Tabcompleater.StatsTab;
import de.nikey.nikey.hex.HexListener;
import de.nikey.nikey.hex.hex;
import de.nikey.nikey.playerlistener.Death;
import de.nikey.nikey.playerlistener.Move;
import de.nikey.nikey.playerlistener.lightning;
import de.nikey.nikey.playerlistener.nomove;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;


public final class Nikey extends JavaPlugin {
    private static Nikey plugin;
    public static ArrayList<Player> player = new ArrayList<>();
    public static ArrayList<Player> nomove = new ArrayList<>();


    @Override
    public void onEnable() {
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
