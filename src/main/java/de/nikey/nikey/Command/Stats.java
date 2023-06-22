package de.nikey.nikey.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

public class Stats implements CommandExecutor {

    public static ArrayList<Player> saturation = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.isOp()){
                if (args.length >= 1){
                    Player player = Bukkit.getPlayer(args[0]);
                    if (player == null){
                        p.sendMessage(ChatColor.RED+ "That doesn't work like so!");
                    }else {
                        if (args[1].equalsIgnoreCase("Invulnerable")){
                            player.setInvulnerable(!player.isInvulnerable());
                            p.sendMessage(ChatColor.AQUA + "You toggled:Invulnerable from " + player.getName());
                        } else if (args[1].equalsIgnoreCase("Flight")) {
                            if(player.isFlying()){
                                player.setAllowFlight(false);
                                player.setFlying(false);
                                p.sendMessage(ChatColor.AQUA + "You toggled:Flight from " + player.getName());
                            }else {
                                player.setAllowFlight(true);
                                p.sendMessage(ChatColor.AQUA + "You toggled:Flight from " + player.getName());;
                                player.setFlying(true);
                            }
                        } else if (args[1].equalsIgnoreCase("Health")) {
                            player.setHealthScale(20);
                            player.setHealth(20);
                            p.sendMessage(ChatColor.AQUA + "You Reseted:Health from " + player.getName());
                        }else if (args[1].equalsIgnoreCase("Saturation")) {
                            if(!saturation.contains(player)){
                                saturation.add(player);
                                p.sendMessage(ChatColor.AQUA + "You toggled:Saturation from " + player.getName());
                            }else {
                                saturation.remove(player);
                                p.sendMessage(ChatColor.AQUA + "You toggled:Saturation from " + player.getName());;
                            }
                        }
                    }
                }else {
                    p.sendMessage(ChatColor.RED+ "That doesn't work like so!");
                }
            }
        }
        return true;
    }

    public static class Kit implements CommandExecutor , TabCompleter {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.isOp()){
                    if (args.length == 2){
                        Player target = Bukkit.getPlayer(args[0]);
                        if (!(target == null)){
                            p.getInventory().clear();
                            if (args[1].equalsIgnoreCase("cpvp")){
                                ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
                                ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                                ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
                                ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
                                helmet.addEnchantment(Enchantment.DURABILITY,3);
                                helmet.addEnchantment(Enchantment.MENDING,1);
                                helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                                chestplate.addEnchantment(Enchantment.DURABILITY,3);
                                chestplate.addEnchantment(Enchantment.MENDING,1);
                                chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                                leggings.addEnchantment(Enchantment.DURABILITY,3);
                                leggings.addEnchantment(Enchantment.MENDING,1);
                                leggings.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS,4);
                                boots.addEnchantment(Enchantment.DURABILITY,3);
                                boots.addEnchantment(Enchantment.MENDING,1);
                                boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                                PlayerInventory inv = p.getInventory();
                                inv.setBoots(boots);
                                inv.setChestplate(chestplate);
                                inv.setLeggings(leggings);
                                inv.setHelmet(helmet);


                                target.performCommand("give @p netherite_sword{Enchantments:[{id:\"minecraft:sharpness\",lvl:5s},{id:\"minecraft:knockback\",lvl:1s},{id:\"minecraft:fire_aspect\",lvl:2s},{id:\"minecraft:looting\",lvl:3s},{id:\"minecraft:sweeping\",lvl:3s},{id:\"minecraft:unbreaking\",lvl:3s},{id:\"minecraft:mending\",lvl:1s}]} 1");
                                target.performCommand("give @p golden_apple 64");
                                target.performCommand("give @p splash_potion{Potion:\"minecraft:strong_strength\"} 3");
                                target.performCommand("give @p splash_potion{Potion:\"minecraft:strong_swiftness\"} 3");
                                target.performCommand("give @p obsidian 128");
                                target.performCommand("give @p respawn_anchor 64");
                                target.performCommand("give @p glowstone 64");
                                target.performCommand("give @p ender_pearl 80");
                                target.performCommand("give @p minecraft:totem_of_undying 12");
                                target.performCommand("give @p experience_bottle 128");
                                target.performCommand("give @p crossbow{Enchantments:[{id:\"minecraft:unbreaking\",lvl:3s},{id:\"minecraft:mending\",lvl:1s},{id:\"minecraft:multishot\",lvl:1s},{id:\"minecraft:quick_charge\",lvl:3s}]} 1");
                                target.performCommand("give @p tipped_arrow{Potion:\"minecraft:long_slow_falling\"} 64");
                                target.performCommand("give @p end_crystal 128");
                                target.performCommand("give @p netherite_pickaxe{Enchantments:[{id:\"minecraft:efficiency\",lvl:5s},{id:\"minecraft:unbreaking\",lvl:3s},{id:\"minecraft:mending\",lvl:1s}]} 1");
                            } else if (args[1].equalsIgnoreCase("Sword")) {
                                ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
                                ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                                ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                                ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                                ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE);
                                //
                                helmet.addEnchantment(Enchantment.DURABILITY,3);
                                helmet.addEnchantment(Enchantment.MENDING,1);
                                helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2);
                                chestplate.addEnchantment(Enchantment.DURABILITY,3);
                                chestplate.addEnchantment(Enchantment.MENDING,1);
                                chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2);
                                leggings.addEnchantment(Enchantment.DURABILITY,3);
                                leggings.addEnchantment(Enchantment.MENDING,1);
                                leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2);
                                boots.addEnchantment(Enchantment.DURABILITY,3);
                                boots.addEnchantment(Enchantment.MENDING,1);
                                boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2);
                                gaps.setAmount(5);
                                target.performCommand("give @p diamond_sword{Enchantments:[{id:\"minecraft:sharpness\",lvl:3s}]} 1");
                                target.performCommand("give @p diamond_axe{Enchantments:[{id:\"minecraft:sharpness\",lvl:2s}]} 1");
                                PlayerInventory inv = target.getInventory();
                                inv.setItemInOffHand(gaps);
                                inv.setBoots(boots);
                                inv.setChestplate(chestplate);
                                inv.setLeggings(leggings);
                                inv.setHelmet(helmet);
                            }else if (args[1].equalsIgnoreCase("Dia1.8")){
                                ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
                                ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                                ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                                ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                                ItemStack shield = new ItemStack(Material.SHIELD);
                                ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
                                //
                                PlayerInventory inv = target.getInventory();
                                helmet.addEnchantment(Enchantment.DURABILITY,3);
                                helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3);
                                chestplate.addEnchantment(Enchantment.DURABILITY,3);
                                chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3);
                                leggings.addEnchantment(Enchantment.DURABILITY,3);
                                leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3);
                                boots.addEnchantment(Enchantment.DURABILITY,3);
                                boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3);
                                axe.addEnchantment(Enchantment.DAMAGE_ALL,1);
                                target.performCommand("give @p diamond_sword{Enchantments:[{id:\"minecraft:sharpness\",lvl:1s}],AttributeModifiers:[{AttributeName:\"generic.attack_speed\",Name:\"generic.attack_speed\",Amount:11111,Operation:2,UUID:[I;246335992,231689302,-1098188631,-729323655]}]} 1");
                                target.performCommand("give @p arrow 10");
                                target.performCommand("give @p bow{Enchantments:[{id:\"minecraft:power\",lvl:1s}]} 1");
                                target.performCommand("give @p golden_apple 10");
                                target.performCommand("give @p diamond_axe 1");
                                inv.setBoots(boots);
                                inv.setChestplate(chestplate);
                                inv.setLeggings(leggings);
                                inv.setHelmet(helmet);
                                inv.setItemInOffHand(shield);
                            }
                        }else {
                            p.sendMessage(ChatColor.RED+ "Error: No target found");
                        }
                    }else {
                        p.sendMessage(ChatColor.RED+ "That doesn't work like so!");
                    }
                }
            }
            return true;
        }

        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
            ArrayList<String> list = new ArrayList<>();
            if (args.length == 2){
                list.clear();
                list.add("cpvp");
                list.add("Sword");
                list.add("Dia1.8");
            }
            if (args.length == 1){
                for (Player player : Bukkit.getOnlinePlayers()){
                    list.clear();
                    list.add(player.getName());
                }
            }
            return list;
        }
    }
}
