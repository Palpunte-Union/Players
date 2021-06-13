package com.github.eighty88.players;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Players extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onPlayerClickInventory(InventoryClickEvent event) {
                if(event.getView().getTitle().equals("Players")) {
                    event.setCancelled(true);
                }
            }
        }, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("players")) {
            if(sender instanceof Player)
                GUI.displayGUI((Player) sender);
            return true;
        }
        return false;
    }
}
