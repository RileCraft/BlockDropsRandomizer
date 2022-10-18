package me.rilecraft.blockdropsrandomizer.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class Shuffle implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("BDR.shuffle") ||  !sender.hasPermission("BDR.*") && sender instanceof Player) sender.sendMessage(ChatColor.GREEN + "[BDR] " + ChatColor.WHITE + "You do not have the required permission to use this command. " + ChatColor.RED + "[BDR.shuffle]");
        else {
            File file = new File(Bukkit.getServer().getPluginManager().getPlugin("BlockDropsRandomizer").getDataFolder() + "/DropsData", "DataFile.yml");
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(ChatColor.RED + "Unable to create CustomConfig File.");
            }

            sender.sendMessage(ChatColor.GREEN + "[BDR] " + ChatColor.WHITE + "Successfully reshuffled all the block's item drops.");
        }
        return true;
    }
}
