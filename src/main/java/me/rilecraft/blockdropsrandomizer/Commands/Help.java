package me.rilecraft.blockdropsrandomizer.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(ChatColor.GREEN + "---- BDR Page 1/1----\n" + ChatColor.GREEN + "/bdr reload " + ChatColor.WHITE + "Reloads the config.yml file.\n" + ChatColor.GREEN + "/bdr toggle " + ChatColor.WHITE + "Enables/Disables the plugin and returns backs to normal block drops.\n" + ChatColor.GREEN + "/bdr shuffle " + ChatColor.WHITE + "Only works if randomizeEachDrop is set to false, This will reassign random item drops to all blocks again.");
        return true;
    }
}
