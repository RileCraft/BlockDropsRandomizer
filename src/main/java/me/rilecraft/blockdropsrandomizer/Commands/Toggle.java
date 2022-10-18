package me.rilecraft.blockdropsrandomizer.Commands;

import me.rilecraft.blockdropsrandomizer.BlockDropsRandomizer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Toggle implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("BDR.toggle") || !sender.hasPermission("BDR.*") && sender instanceof Player) sender.sendMessage(ChatColor.GREEN + "[BDR] " + ChatColor.WHITE + "You do not have the required permission to use this command. " + ChatColor.RED + "[BDR.toggle]");
        else {
            Configuration config = BlockDropsRandomizer.getPlugin(BlockDropsRandomizer.class).getConfig();
            if (config.getBoolean("BDR.enabled")) {
                config.set("BDR.enabled", false);
                sender.sendMessage(ChatColor.GREEN + "[BDR] " + ChatColor.WHITE + "Disabled Block Randomization :(");
            } else if (!config.getBoolean("BDR.enabled")) {
                config.set("BDR.enabled", true);
                sender.sendMessage(ChatColor.GREEN + "[BDR] " + ChatColor.WHITE + "Enabled Block Randomization :D");
            }
        }
        return true;
    }
}
