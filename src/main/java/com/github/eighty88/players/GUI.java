package com.github.eighty88.players;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class GUI {
    private static Inventory inventory;

    public static void displayGUI(Player player) {
        initializeGUI();
        player.openInventory(inventory);
    }

    public static void initializeGUI() {
        inventory = Bukkit.createInventory(null, 56, "Players");

        for(Player player: Bukkit.getOnlinePlayers()) {
            ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) stack.getItemMeta();
            skullMeta.setOwningPlayer(player);
            stack.setItemMeta(skullMeta);
            inventory.addItem(stack);
        }
    }
}
