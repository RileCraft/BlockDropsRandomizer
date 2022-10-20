package me.rilecraft.blockdropsrandomizer.TabCompletor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BDR implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 0) {
            List<String> Options = new ArrayList<>();
            Options.add("shuffle");
            Options.add("reload");
            Options.add("toggle");
            return Options;
        }
        return null;
    }
}
