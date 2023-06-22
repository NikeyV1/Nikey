package de.nikey.nikey.util;

import de.nikey.nikey.Capabilities.Explosion;
import de.nikey.nikey.Capabilities.Frostnova;
import de.nikey.nikey.Capabilities.Netherinferno;
import de.nikey.nikey.Capabilities.Soul_Dagger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Scoreboardutils {
    public static Scoreboard setBaseScoreboard(Player player){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("§8>> §6§l§nNikey§r §8<<" ,"dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("§6legends.feathermc.gg").setScore(0);
        objective.getScore("§f§lCooldowns:").setScore(7);
        objective.getScore("Rank:").setScore(2);
        objective.getScore(player.isOp() ? "§cAdmin" : "§7Player").setScore(1);
        objective.getScore("§4").setScore(0);

        if (!Explosion.map.containsKey(player) || Explosion.map.get(player) == 30){
            objective.getScore("§4Ignition Blade: §aReady").setScore(6);
        }else {
            objective.getScore("§4Ignition Blade: " +"§f"+ Explosion.map.get(player)).setScore(6);
        }
        objective.getScore("§3Soul Dagger: " +"§f"+ Soul_Dagger.map.get(player)+"/12").setScore(3);
        if (Netherinferno.red == true){
            if (!Netherinferno.map.containsKey(player)){
                objective.getScore("§cInferno: §aReady").setScore(5);
            }else {
                objective.getScore("§cInferno: " + "§f" + Netherinferno.map.get(player)).setScore(5);
            }
        }else {
            if (!Netherinferno.map.containsKey(player)){
                objective.getScore("§bInferno: §aReady").setScore(5);
            }else {
                objective.getScore("§bInferno: " + "§f" + Netherinferno.map.get(player)).setScore(5);
            }
        }
        if (!Frostnova.map.containsKey(player)||Frostnova.map.get(player) == 30){
            objective.getScore("§1Frostnova: §aReady").setScore(4);
        }else {
            objective.getScore("§1Frostnova: "+"§f" + Frostnova.map.get(player)).setScore(4);
        }
        player.setScoreboard(s);
        return s;
    }
}