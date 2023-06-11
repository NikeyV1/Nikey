package de.nikey.nikey.hex;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HexListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory.getSize() == 45){
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            Player p = player;
            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE,1,1);
            int level = player.getLevel();
            ItemStack stack = inventory.getItem(22);
            ItemMeta invmeta = stack.getItemMeta();
            ItemStack hand = player.getItemInHand();
            ItemMeta handmeta = hand.getItemMeta();
            if (!(event.getCurrentItem().getType() == Material.ENCHANTED_BOOK)){
            }else {
                if (inventory.getItem(22).getType() == Material.NETHERITE_SWORD ||inventory.getItem(22).getType() == Material.DIAMOND_SWORD || inventory.getItem(22).getType() == Material.IRON_SWORD){

                    ItemStack item = event.getCurrentItem();
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase("Mending")){
                        if (level >=14){
                            stack.addEnchantment(Enchantment.MENDING,1);
                            player.getItemInHand().addEnchantment(Enchantment.MENDING,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-14);
                            }
                        }
                    } else if (meta.getDisplayName().equalsIgnoreCase("Sharpness 5")) {
                        if (level >=38){
                            hand.addEnchantment(Enchantment.DAMAGE_ALL,5);
                            stack.addEnchantment(Enchantment.DAMAGE_ALL,5);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-38);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Unbreaking 3")) {
                        if (level >=26){
                            stack.addEnchantment(Enchantment.DURABILITY,3);
                            player.getItemInHand().addEnchantment(Enchantment.DURABILITY,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-26);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Smite 5")) {
                        if (level >= 38) {
                            hand.addEnchantment(Enchantment.DAMAGE_UNDEAD,5);
                            stack.addEnchantment(Enchantment.DAMAGE_UNDEAD,5);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-38);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Knockback 1")) {
                        if (level >= 21) {
                            hand.addEnchantment(Enchantment.KNOCKBACK,1);
                            stack.addEnchantment(Enchantment.KNOCKBACK,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-21);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Knockback 2")) {
                        if (level >= 23) {
                            hand.addEnchantment(Enchantment.KNOCKBACK,2);
                            stack.addEnchantment(Enchantment.KNOCKBACK,2);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-23);
                            }
                        }
                    }
                    else if (meta.getDisplayName().equalsIgnoreCase("Unbreakable")) {
                        if (level >= 100) {
                            ItemMeta m = p.getItemInHand().getItemMeta();
                            m.setUnbreakable(true);
                            p.getItemInHand().setItemMeta(m);
                            //
                            ItemMeta i = inventory.getItem(22).getItemMeta();
                            i.setUnbreakable(true);
                            inventory.getItem(22).setItemMeta(i);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-100);
                            }
                        }
                    }
                } else if (inventory.getItem(22).getType() == Material.NETHERITE_HELMET||inventory.getItem(22).getType() == Material.NETHERITE_CHESTPLATE||inventory.getItem(22).getType() == Material.NETHERITE_LEGGINGS || inventory.getItem(22).getType() == Material.NETHERITE_BOOTS ||inventory.getItem(22).getType() == Material.DIAMOND_HELMET || inventory.getItem(22).getType() == Material.DIAMOND_CHESTPLATE || inventory.getItem(22).getType() == Material.DIAMOND_LEGGINGS || inventory.getItem(22).getType() == Material.DIAMOND_BOOTS) {
                    ItemStack item = event.getCurrentItem();
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase("Mending")){
                        if (level >=14){
                            stack.addEnchantment(Enchantment.MENDING,1);
                            hand.addEnchantment(Enchantment.MENDING,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-14);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Protection 4")) {
                        if (level >= 37) {
                            hand.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                            stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-37);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Blast Protection 4")) {
                        if (level >= 35) {
                            hand.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS,4);
                            stack.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS,4);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-35);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Unbreaking 3")) {
                        if (level >= 26) {
                            hand.addEnchantment(Enchantment.DURABILITY,3);
                            stack.addEnchantment(Enchantment.DURABILITY,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-26);
                            }
                        }
                    }
                    else if (meta.getDisplayName().equalsIgnoreCase("Unbreakable")) {
                        if (level >= 100) {

                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-100);
                            }
                        }
                    }
                } else if (inventory.getItem(22).getType() == Material.SHIELD ||inventory.getItem(22).getType() == Material.FLINT_AND_STEEL) {
                    ItemStack item = event.getCurrentItem();
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase("Mending")){
                        if (level >=14){
                            stack.addEnchantment(Enchantment.MENDING,1);
                            hand.addEnchantment(Enchantment.MENDING,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-14);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Unbreaking 3")) {
                        if (level >= 26) {
                            hand.addEnchantment(Enchantment.DURABILITY,3);
                            stack.addEnchantment(Enchantment.DURABILITY,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-26);
                            }
                        }
                    }
                }else if (inventory.getItem(22).getType() == Material.CROSSBOW) {
                    ItemStack item = event.getCurrentItem();
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase("Mending")){
                        if (level >=14){
                            stack.addEnchantment(Enchantment.MENDING,1);
                            hand.addEnchantment(Enchantment.MENDING,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-14);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Unbreaking 3")) {
                        if (level >= 26) {
                            hand.addEnchantment(Enchantment.DURABILITY,3);
                            stack.addEnchantment(Enchantment.DURABILITY,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-26);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Quick Charge 3")) {
                        if (level >= 36) {
                            hand.addEnchantment(Enchantment.QUICK_CHARGE,3);
                            stack.addEnchantment(Enchantment.QUICK_CHARGE,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-36);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Piercing 4")) {
                        if (level >= 31) {
                            hand.addEnchantment(Enchantment.PIERCING,4);
                            stack.addEnchantment(Enchantment.PIERCING,4);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-31);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Multishot")) {
                        if (level >= 31) {
                            hand.addEnchantment(Enchantment.MULTISHOT,1);
                            stack.addEnchantment(Enchantment.MULTISHOT,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-29);
                            }
                        }
                    }
                }else if (inventory.getItem(22).getType() == Material.BOW) {
                    ItemStack item = event.getCurrentItem();
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase("Mending")){
                        if (level >=14){
                            stack.addEnchantment(Enchantment.MENDING,1);
                            hand.addEnchantment(Enchantment.MENDING,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-14);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Unbreaking 3")) {
                        if (level >= 26) {
                            hand.addEnchantment(Enchantment.DURABILITY,3);
                            stack.addEnchantment(Enchantment.DURABILITY,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-26);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Power 5")) {
                        if (level >= 36) {
                            hand.addEnchantment(Enchantment.ARROW_DAMAGE,5);
                            stack.addEnchantment(Enchantment.ARROW_DAMAGE,5);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-36);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Punch 2")) {
                        if (level >= 24) {
                            hand.addEnchantment(Enchantment.ARROW_KNOCKBACK,2);
                            stack.addEnchantment(Enchantment.ARROW_KNOCKBACK,2);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-24);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Infinity")) {
                        if (level >= 31) {
                            hand.addEnchantment(Enchantment.ARROW_INFINITE,1);
                            stack.addEnchantment(Enchantment.ARROW_INFINITE,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-31);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Flame")) {
                        if (level >= 27) {
                            hand.addEnchantment(Enchantment.ARROW_FIRE,1);
                            stack.addEnchantment(Enchantment.ARROW_FIRE,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-27);
                            }
                        }
                    }
                    else if (meta.getDisplayName().equalsIgnoreCase("Unbreakable")) {
                        if (level >= 100) {
                            invmeta.setUnbreakable(true);
                            handmeta.setUnbreakable(true);
                            hand.setItemMeta(handmeta);
                            stack.setItemMeta(invmeta);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-100);
                            }
                        }
                    }
                }else if (inventory.getItem(22).getType() == Material.TRIDENT){
                    ItemStack item = event.getCurrentItem();
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase("Mending")){
                        if (level >=14){
                            stack.addEnchantment(Enchantment.MENDING,1);
                            hand.addEnchantment(Enchantment.MENDING,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-14);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Unbreaking 3")) {
                        if (level >= 26) {
                            hand.addEnchantment(Enchantment.DURABILITY,3);
                            stack.addEnchantment(Enchantment.DURABILITY,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-26);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Channeling")) {
                        if (level >= 31) {
                            hand.addEnchantment(Enchantment.CHANNELING,1);
                            stack.addEnchantment(Enchantment.CHANNELING,1);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-31);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Riptide 3")) {
                        if (level >= 37) {
                            hand.addEnchantment(Enchantment.RIPTIDE,3);
                            stack.addEnchantment(Enchantment.RIPTIDE,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-37);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Loyalty 3")) {
                        if (level >= 28) {
                            hand.addEnchantment(Enchantment.LOYALTY,3);
                            stack.addEnchantment(Enchantment.LOYALTY,3);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-28);
                            }
                        }
                    }else if (meta.getDisplayName().equalsIgnoreCase("Impaling 5")) {
                        if (level >= 22) {
                            hand.addEnchantment(Enchantment.IMPALING,5);
                            stack.addEnchantment(Enchantment.IMPALING,5);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-22);
                            }
                        }
                    }
                    else if (meta.getDisplayName().equalsIgnoreCase("Unbreakable")) {
                        if (level >= 100) {
                            invmeta.setUnbreakable(true);
                            handmeta.setUnbreakable(true);
                            hand.setItemMeta(handmeta);
                            stack.setItemMeta(invmeta);
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-100);
                            }
                        }
                    }
                }else if (inventory.getItem(22).getType() == Material.NETHERITE_PICKAXE || inventory.getItem(22).getType() == Material.DIAMOND_PICKAXE) {
                    ItemStack item = event.getCurrentItem();
                    ItemMeta meta = item.getItemMeta();
                    if (meta.getDisplayName().equalsIgnoreCase("Mending")) {
                        if (level >= 14) {
                            stack.addEnchantment(Enchantment.MENDING, 1);
                            hand.addEnchantment(Enchantment.MENDING, 1);
                            if (player.getGameMode() != GameMode.CREATIVE) {
                                player.setLevel(level - 14);
                            }
                        }
                    } else if (meta.getDisplayName().equalsIgnoreCase("Unbreaking 3")) {
                        if (level >= 26) {
                            hand.addEnchantment(Enchantment.DURABILITY, 3);
                            stack.addEnchantment(Enchantment.DURABILITY, 3);
                            if (player.getGameMode() != GameMode.CREATIVE) {
                                player.setLevel(level - 26);
                            }
                        }
                    } else if (meta.getDisplayName().equalsIgnoreCase("Efficiency 5")) {
                        if (level >= 34) {
                            hand.addEnchantment(Enchantment.DIG_SPEED, 5);
                            stack.addEnchantment(Enchantment.DIG_SPEED, 5);

                            if (player.getGameMode() != GameMode.CREATIVE) {
                                player.setLevel(level - 34);
                            }
                        }
                    } else if (meta.getDisplayName().equalsIgnoreCase("Fortune 3")) {
                        if (level >= 31) {
                            hand.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
                            stack.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
                            if (player.getGameMode() != GameMode.CREATIVE) {
                                player.setLevel(level - 31);
                            }
                        }
                    } else if (meta.getDisplayName().equalsIgnoreCase("Silk Touch")) {
                        if (level >= 28) {
                            hand.addEnchantment(Enchantment.SILK_TOUCH, 1);
                            stack.addEnchantment(Enchantment.SILK_TOUCH, 1);
                            if (player.getGameMode() != GameMode.CREATIVE) {
                                player.setLevel(level - 28);
                            }
                        }
                    }else if (item.getType() == Material.AMETHYST_SHARD) {
                        p.sendMessage("0");
                        if (level >= 100) {
                            p.sendMessage("1");
                            invmeta.setUnbreakable(true);
                            handmeta.setUnbreakable(true);
                            hand.setItemMeta(handmeta);
                            stack.setItemMeta(invmeta);
                            p.sendMessage("2");
                            if (player.getGameMode() != GameMode.CREATIVE){
                                player.setLevel(level-100);
                            }
                        }
                    }else {
                        ItemStack currentItem = event.getCurrentItem();
                        p.sendMessage(String.valueOf(currentItem));
                    }
                }
            }
        }
    }
}
