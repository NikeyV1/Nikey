package de.nikey.nikey.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Scoreboardutils {
    public static Scoreboard setBaseScoreboard(Player player,Integer cooldown ,Boolean sneaking,Boolean explosion,Boolean inferno,Boolean red , Boolean frostnova){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("§8>> §5§l§nCooldowns§r §8<<" ,"dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("                  ").setScore(3);
        if (explosion == true){
            if (sneaking == true){
                if (cooldown <30){
                    objective.getScore("§4Ignition Blade: " + "§f" + cooldown).setScore(1);
                }else {
                    objective.getScore("§4Ignition Blade: " + "§aReady").setScore(1);
                }
            }else {
                if (cooldown <20){
                    objective.getScore("§4Ignition Blade: " + "§f" + cooldown).setScore(1);
                }else {
                    objective.getScore("§4Ignition Blade: " + "§aReady").setScore(1);
                }
            }
        }else if (inferno == true){
            if (red == true){
                if (cooldown <40){
                    objective.getScore("§cInferno: " + "§f" + cooldown).setScore(2);
                }else {
                    objective.getScore("§cInferno: " + "§aReady").setScore(2);
                }
            }else {
                if (cooldown <8){
                    objective.getScore("§bInferno: " + "§f" + cooldown).setScore(2);
                }else {
                    objective.getScore("§bInferno: " + "§aReady").setScore(2);
                }
            }
        } else if (frostnova == true) {

        }
        player.setScoreboard(s);
        return s;
    }
}
