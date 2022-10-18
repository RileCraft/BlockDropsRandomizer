package me.rilecraft.blockdropsrandomizer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfigHandler {
    private static File file;
    private static FileConfiguration customConfig;

    public static void SetupFile() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockDropsRandomizer").getDataFolder() + "/DropsData", "DataFile.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Error | IOException e) {
                System.out.println(ChatColor.RED + "Unable to create CustomConfig File.");
            }
        }
        customConfig = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration Get() {
        return customConfig;
    }

    public static void Save() {
        try {
            customConfig.save(file);
        } catch (Error | IOException e) {
            System.out.println(ChatColor.RED + "Unable to save CustomConfig File.");
        }
    }

    public static void Reload() {
        customConfig = YamlConfiguration.loadConfiguration(file);
    }

}
