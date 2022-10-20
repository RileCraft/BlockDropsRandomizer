package me.rilecraft.blockdropsrandomizer;

import me.rilecraft.blockdropsrandomizer.Commands.*;
import me.rilecraft.blockdropsrandomizer.Listeners.BlockBreak;
import me.rilecraft.blockdropsrandomizer.Listeners.EntityExplode;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockDropsRandomizer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Prepare Configuration File.
       saveDefaultConfig();
       CustomConfigHandler.SetupFile();
       CustomConfigHandler.Get().options().copyDefaults(true);
       CustomConfigHandler.Save();
       System.out.println(ChatColor.GREEN + "[BDR] " + ChatColor.BLUE + "Let the fun begin ;)");

       // Registering Commands
        getCommand("BDR").setExecutor(new BDR());
        getCommand("BDR").setTabCompleter(new me.rilecraft.blockdropsrandomizer.TabCompletor.BDR());

       // Registering Listeners
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new EntityExplode(), this);
    }
}
