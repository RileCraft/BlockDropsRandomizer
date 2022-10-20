package me.rilecraft.blockdropsrandomizer.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BDR implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) return new Help().onCommand(sender, command, label, args);
        else if (args[0].equalsIgnoreCase("reload")) return new Reload().onCommand(sender, command, label, args);
        else if (args[0].equalsIgnoreCase("shuffle")) return new Shuffle().onCommand(sender, command, label, args);
        else if (args[0].equalsIgnoreCase("toggle")) return new Toggle().onCommand(sender, command, label, args);
        else sender.sendMessage(ChatColor.GREEN + "[BDR] " + ChatColor.WHITE + "Invalid argument was provided.");
        return true;
    }
}
