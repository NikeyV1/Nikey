package de.nikey.nikey.util;

import de.nikey.nikey.Capabilities.Explosion;
import de.nikey.nikey.Capabilities.Frostnova;
import de.nikey.nikey.Capabilities.Netherinferno;
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
        objective.getScore("§l§fCooldowns:").setScore(7);
        objective.getScore("Rank:").setScore(3);
        objective.getScore(player.isOp() ? "§cAdmin" : "§7Player").setScore(2);
        objective.getScore("§4").setScore(1);
        objective.getScore("§4").setScore(0);
        if (Netherinferno.red == true){
            if (Netherinferno.map.get(player) == null){
                objective.getScore("§cInferno: §aReady").setScore(5);
            }else {
                objective.getScore("§cInferno: " + "§f" + Netherinferno.map.get(player)).setScore(5);
            }
        }else {
            if (Netherinferno.map.get(player) == null){
                objective.getScore("§bInferno: §aReady").setScore(5);
            }else {
                objective.getScore("§bInferno: " + "§f" + Netherinferno.map.get(player)).setScore(5);
            }
        }
        if (Frostnova.map.get(player) == null){
            objective.getScore("§1Frostnova: §aReady").setScore(4);
        }else {
            objective.getScore("§1Frostnova: "+"§f" + Frostnova.map.get(player)).setScore(4);
        }

        if (Explosion.map.get(player) == null || Explosion.map.get(player) == 30){
            objective.getScore("§4Ignition Blade: §aReady").setScore(6);
        }else {
            objective.getScore("§4Ignition Blade: "+ Explosion.map.get(player)).setScore(6);
        }
        player.setScoreboard(s);
        return s;
    }
}
