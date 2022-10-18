package me.rilecraft.blockdropsrandomizer;

import me.rilecraft.blockdropsrandomizer.Commands.Help;
import me.rilecraft.blockdropsrandomizer.Commands.Reload;
import me.rilecraft.blockdropsrandomizer.Commands.Shuffle;
import me.rilecraft.blockdropsrandomizer.Commands.Toggle;
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
        getCommand("Help").setExecutor(new Help());
        getCommand("Reload").setExecutor(new Reload());
        getCommand("Toggle").setExecutor(new Toggle());
        getCommand("Shuffle").setExecutor(new Shuffle());

       // Registering Listeners
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new EntityExplode(), this);
    }
}
