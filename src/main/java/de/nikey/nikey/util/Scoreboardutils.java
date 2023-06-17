package de.nikey.nikey.util;

import de.nikey.nikey.Capabilities.Netherinferno;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Scoreboardutils {
    public static Scoreboard getBaseScoreboard(){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("Cooldowns" , String.valueOf(Criteria.create("Cooldown")));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("Ignition Blade: ").setScore(0);
        objective.getScore("Inferno: " + Netherinferno.inferno.get(1)).setScore(0);
        objective.getScore("").setScore(0);
        objective.getScore("").setScore(0);
        objective.getScore("").setScore(0);
        objective.getScore("").setScore(0);
        return s;
    }
}
