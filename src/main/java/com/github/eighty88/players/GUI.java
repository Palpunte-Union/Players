package com.github.eighty88.players;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Objects;

public class GUI {
    public static void displayGUI(Player player) {
        Inventory inventory = initializeGUI();
        player.openInventory(inventory);
    }

    public static Inventory initializeGUI() {
        Inventory inventory = Bukkit.createInventory(null, 54, "Players");

        for(Player player: Bukkit.getOnlinePlayers()) {
            ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) stack.getItemMeta();
            assert skullMeta != null;
            Objects.requireNonNull(skullMeta).setOwningPlayer(player);
            skullMeta.setDisplayName(ChatColor.RESET.toString() + ChatColor.AQUA + player.getName());
            stack.setItemMeta(skullMeta);
            inventory.addItem(stack);
        }
        return inventory;
    }
}
