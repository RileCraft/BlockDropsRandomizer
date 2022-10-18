package me.rilecraft.blockdropsrandomizer.Commands;

import me.rilecraft.blockdropsrandomizer.BlockDropsRandomizer;
import me.rilecraft.blockdropsrandomizer.CustomConfigHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("BDR.reload") || !sender.hasPermission("BDR.*") && sender instanceof Player) sender.sendMessage(ChatColor.GREEN + "[BDR] " + ChatColor.WHITE + "You do not have the required permission to use this command. " + ChatColor.RED + "[BDR.reload]");
        else {
            Plugin plugin = BlockDropsRandomizer.getPlugin(BlockDropsRandomizer.class);
            plugin.reloadConfig();
            CustomConfigHandler.Reload();
            sender.sendMessage(ChatColor.GREEN + "[BDR] " + ChatColor.WHITE + "Reloaded config.yml.");
        }
        return true;
    }
}
