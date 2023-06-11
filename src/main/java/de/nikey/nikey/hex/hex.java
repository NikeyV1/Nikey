package de.nikey.nikey.hex;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class hex implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            Inventory hex = Bukkit.createInventory(null, 45, "§cThe Hex");
            ItemStack purple = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            ItemStack br = new ItemStack(Material.AMETHYST_SHARD);
            ItemMeta brm = br.getItemMeta();
            brm.setDisplayName("Unbreakable");
            br.setItemMeta(brm);
            if (p.getItemInHand().getType() == Material.NETHERITE_SWORD || p.getItemInHand().getType() == Material.DIAMOND_SWORD ||p.getItemInHand().getType() == Material.IRON_SWORD){
                ItemStack sharpness = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta itemMeta = sharpness.getItemMeta();
                itemMeta.setDisplayName("Sharpness 5");
                sharpness.setItemMeta(itemMeta);
                ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta aitemMeta = unbreaking.getItemMeta();
                aitemMeta.setDisplayName("Unbreaking 3");
                unbreaking.setItemMeta(aitemMeta);
                ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta aaitemMeta = mending.getItemMeta();
                aaitemMeta.setDisplayName("Mending");
                mending.setItemMeta(aaitemMeta);
                //
                ItemStack smite = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta smitemet = smite.getItemMeta();
                smitemet.setDisplayName("Smite 5");
                smite.setItemMeta(smitemet);
                //
                ItemStack kb = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta kbm = kb.getItemMeta();
                kbm.setDisplayName("Knockback 1");
                kb.setItemMeta(kbm);
                //
                ItemStack kbt = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta kbmt = kbt.getItemMeta();
                kbmt.setDisplayName("Knockback 2");
                kbt.setItemMeta(kbmt);
                //
                ItemStack item = p.getItemInHand();
                ItemMeta meta = p.getItemInHand().getItemMeta();
                item.setItemMeta(meta);
                //
                hex.setItem(11,br);
                hex.setItem(12,purple);
                hex.setItem(13,purple);
                hex.setItem(14,purple);
                hex.setItem(21,purple);
                hex.setItem(23,purple);
                hex.setItem(30,purple);
                hex.setItem(31,purple);
                hex.setItem(32,purple);
                hex.setItem(15,sharpness);
                hex.setItem(16,unbreaking);
                hex.setItem(17,mending);
                hex.setItem(22,item);
                hex.setItem(24,smite);
                hex.setItem(25,kb);
                hex.setItem(26,kbt);


                p.openInventory(hex);
            }else if (p.getItemInHand().getType() == Material.NETHERITE_HELMET||p.getItemInHand().getType() == Material.NETHERITE_CHESTPLATE||p.getItemInHand().getType() == Material.NETHERITE_LEGGINGS || p.getItemInHand().getType() == Material.NETHERITE_BOOTS ||p.getItemInHand().getType() == Material.DIAMOND_HELMET || p.getItemInHand().getType() == Material.DIAMOND_CHESTPLATE || p.getItemInHand().getType() == Material.DIAMOND_LEGGINGS || p.getItemInHand().getType() == Material.DIAMOND_BOOTS){
                ItemStack prot = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta pmeta = prot.getItemMeta();
                pmeta.setDisplayName("Protection 4");
                prot.setItemMeta(pmeta);

                ItemStack bprot = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta bmeta = bprot.getItemMeta();
                bmeta.setDisplayName("Blast Protection 4");
                bprot.setItemMeta(bmeta);

                ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta aaitemMeta = mending.getItemMeta();
                aaitemMeta.setDisplayName("Mending");
                mending.setItemMeta(aaitemMeta);

                ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta aitemMeta = unbreaking.getItemMeta();
                aitemMeta.setDisplayName("Unbreaking 3");
                unbreaking.setItemMeta(aitemMeta);
                //player
                ItemStack item = p.getItemInHand();
                ItemMeta meta = p.getItemInHand().getItemMeta();
                item.setItemMeta(meta);
                //hex
                hex.setItem(11,br);
                hex.setItem(12,purple);
                hex.setItem(13,purple);
                hex.setItem(14,purple);
                hex.setItem(21,purple);
                hex.setItem(23,purple);
                hex.setItem(30,purple);
                hex.setItem(31,purple);
                hex.setItem(32,purple);
                hex.setItem(22,item);
                hex.setItem(15,prot);
                hex.setItem(16,unbreaking);
                hex.setItem(17,mending);
                hex.setItem(24,bprot);

                p.openInventory(hex);
            }else if (p.getItemInHand().getType() == Material.SHIELD || p.getItemInHand().getType() == Material.FLINT_AND_STEEL){
                ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta mendingmeta = mending.getItemMeta();
                mendingmeta.setDisplayName("Mending");
                mending.setItemMeta(mendingmeta);

                ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta unbreakingmeta = unbreaking.getItemMeta();
                unbreakingmeta.setDisplayName("Unbreaking 3");
                unbreaking.setItemMeta(unbreakingmeta);
                //player
                ItemStack item = p.getItemInHand();
                ItemMeta meta = p.getItemInHand().getItemMeta();
                item.setItemMeta(meta);
                //hex
                hex.setItem(11,br);
                hex.setItem(12,purple);
                hex.setItem(13,purple);
                hex.setItem(14,purple);
                hex.setItem(21,purple);
                hex.setItem(23,purple);
                hex.setItem(30,purple);
                hex.setItem(31,purple);
                hex.setItem(32,purple);
                hex.setItem(22,item);
                hex.setItem(15,unbreaking);
                hex.setItem(16,mending);

                p.openInventory(hex);
            } else if (p.getItemInHand().getType() == Material.CROSSBOW){
                ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta mendingmeta = mending.getItemMeta();
                mendingmeta.setDisplayName("Mending");
                mending.setItemMeta(mendingmeta);

                ItemStack piercing = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta piercingmeta = piercing.getItemMeta();
                piercingmeta.setDisplayName("Piercing 4");
                piercing.setItemMeta(piercingmeta);

                ItemStack multishot = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta multimeta = multishot.getItemMeta();
                multimeta.setDisplayName("Multishot");
                multishot.setItemMeta(multimeta);

                ItemStack quickcharge = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta quickchargemeta = quickcharge.getItemMeta();
                quickchargemeta.setDisplayName("Quick Charge 3");
                quickcharge.setItemMeta(quickchargemeta);

                ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta unbreakingmeta = unbreaking.getItemMeta();
                unbreakingmeta.setDisplayName("Unbreaking 3");
                unbreaking.setItemMeta(unbreakingmeta);
                //player
                ItemStack item = p.getItemInHand();
                ItemMeta meta = p.getItemInHand().getItemMeta();
                item.setItemMeta(meta);
                //hex
                hex.setItem(11,br);
                hex.setItem(12,purple);
                hex.setItem(13,purple);
                hex.setItem(14,purple);
                hex.setItem(21,purple);
                hex.setItem(23,purple);
                hex.setItem(30,purple);
                hex.setItem(31,purple);
                hex.setItem(32,purple);
                hex.setItem(22,item);
                hex.setItem(15,unbreaking);
                hex.setItem(16,mending);
                hex.setItem(17,multishot);
                hex.setItem(24,quickcharge);
                hex.setItem(25,piercing);

                p.openInventory(hex);
            }else if (p.getItemInHand().getType() == Material.BOW){
                ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta mendingmeta = mending.getItemMeta();
                mendingmeta.setDisplayName("Mending");
                mending.setItemMeta(mendingmeta);

                ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta unbreakingmeta = unbreaking.getItemMeta();
                unbreakingmeta.setDisplayName("Unbreaking 3");
                unbreaking.setItemMeta(unbreakingmeta);

                ItemStack infinity = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta infinitymeta = infinity.getItemMeta();
                infinitymeta.setDisplayName("Infinity");
                infinity.setItemMeta(infinitymeta);

                ItemStack power = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta powermeta = power.getItemMeta();
                powermeta.setDisplayName("Power 5");
                power.setItemMeta(powermeta);

                ItemStack punch = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta punchmeta = punch.getItemMeta();
                punchmeta.setDisplayName("Punch 2");
                punch.setItemMeta(punchmeta);

                ItemStack flame = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta flamemeta = flame.getItemMeta();
                flamemeta.setDisplayName("Flame");
                flame.setItemMeta(flamemeta);
                //player
                ItemStack item = p.getItemInHand();
                ItemMeta meta = p.getItemInHand().getItemMeta();
                item.setItemMeta(meta);
                //hex
                hex.setItem(11,br);
                hex.setItem(12,purple);
                hex.setItem(13,purple);
                hex.setItem(14,purple);
                hex.setItem(21,purple);
                hex.setItem(23,purple);
                hex.setItem(30,purple);
                hex.setItem(31,purple);
                hex.setItem(32,purple);
                hex.setItem(22,item);
                hex.setItem(15,unbreaking);
                hex.setItem(16,mending);
                hex.setItem(17,infinity);
                hex.setItem(24,power);
                hex.setItem(25,punch);
                hex.setItem(26,flame);

                p.openInventory(hex);
            }else if (p.getItemInHand().getType() == Material.TRIDENT){
                ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta mendingmeta = mending.getItemMeta();
                mendingmeta.setDisplayName("Mending");
                mending.setItemMeta(mendingmeta);

                ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta unbreakingmeta = unbreaking.getItemMeta();
                unbreakingmeta.setDisplayName("Unbreaking 3");
                unbreaking.setItemMeta(unbreakingmeta);

                ItemStack impaling = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta impalingmeta = impaling.getItemMeta();
                impalingmeta.setDisplayName("Impaling 5");
                impaling.setItemMeta(impalingmeta);

                ItemStack loyalty = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta loyaltymeta = loyalty.getItemMeta();
                loyaltymeta.setDisplayName("Loyalty 3");
                loyalty.setItemMeta(loyaltymeta);

                ItemStack riptide = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta riptidemeta = riptide.getItemMeta();
                riptidemeta.setDisplayName("Riptide 3");
                riptide.setItemMeta(riptidemeta);

                ItemStack channeling = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta channelingmeta = channeling.getItemMeta();
                channelingmeta.setDisplayName("Channeling");
                channeling.setItemMeta(channelingmeta);
                //player
                ItemStack item = p.getItemInHand();
                ItemMeta meta = p.getItemInHand().getItemMeta();
                item.setItemMeta(meta);
                //hex
                hex.setItem(11,br);
                hex.setItem(12,purple);
                hex.setItem(13,purple);
                hex.setItem(14,purple);
                hex.setItem(21,purple);
                hex.setItem(23,purple);
                hex.setItem(30,purple);
                hex.setItem(31,purple);
                hex.setItem(32,purple);
                hex.setItem(22,item);
                hex.setItem(15,unbreaking);
                hex.setItem(16,mending);
                hex.setItem(17,impaling);
                hex.setItem(24,loyalty);
                hex.setItem(25,riptide);
                hex.setItem(26,channeling);
                p.openInventory(hex);
            }else if (p.getItemInHand().getType() == Material.NETHERITE_PICKAXE || p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
                ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta mendingmeta = mending.getItemMeta();
                mendingmeta.setDisplayName("Mending");
                mending.setItemMeta(mendingmeta);

                ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta unbreakingmeta = unbreaking.getItemMeta();
                unbreakingmeta.setDisplayName("Unbreaking 3");
                unbreaking.setItemMeta(unbreakingmeta);

                ItemStack efficiency = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta efficiencymeta = efficiency.getItemMeta();
                efficiencymeta.setDisplayName("Efficiency 5");
                efficiency.setItemMeta(efficiencymeta);

                ItemStack fortune = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta fortunemeta = fortune.getItemMeta();
                fortunemeta.setDisplayName("Fortune 3");
                fortune.setItemMeta(fortunemeta);

                ItemStack silk = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta silkmeta = silk.getItemMeta();
                silkmeta.setDisplayName("Silk Touch");
                silk.setItemMeta(silkmeta);
                //player
                ItemStack item = p.getItemInHand();
                ItemMeta meta = p.getItemInHand().getItemMeta();
                item.setItemMeta(meta);
                //hex
                hex.setItem(11,br);
                hex.setItem(12, purple);
                hex.setItem(13, purple);
                hex.setItem(14, purple);
                hex.setItem(21, purple);
                hex.setItem(23, purple);
                hex.setItem(30, purple);
                hex.setItem(31, purple);
                hex.setItem(32, purple);
                hex.setItem(22, item);
                hex.setItem(15, unbreaking);
                hex.setItem(16, mending);
                hex.setItem(17, efficiency);
                hex.setItem(24, silk);
                hex.setItem(25, fortune);

                p.openInventory(hex);
            }else {
                p.sendMessage(ChatColor.RED+ "That doesn't work like so!");
            }
        }else {
            System.out.println("You aren't a Player");
        }
        return true;
    }
}
