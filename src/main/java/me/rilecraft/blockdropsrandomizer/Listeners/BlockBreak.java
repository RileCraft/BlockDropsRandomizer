package me.rilecraft.blockdropsrandomizer.Listeners;

import me.rilecraft.blockdropsrandomizer.BlockDropsRandomizer;
import me.rilecraft.blockdropsrandomizer.CustomConfigHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent Event) {
        Block blockBroken = Event.getBlock();
        Configuration config = getPlugin(BlockDropsRandomizer.class).getConfig();
        if (!config.getBoolean("BDR.enabled")) return;
        List<String> blacklistedBlocks = config.getStringList("BDR.blacklistedBlocks");
        Event.setDropItems(false);
        Object[] allItems = Arrays.stream(Material.values()).toArray();
        ConfigurationSection itemsList = config.getConfigurationSection("BDR.FixedList.items");
        Configuration pluginConfig = CustomConfigHandler.Get();

        if (itemsList != null && itemsList.contains(blockBroken.getType().name().toUpperCase())) {
                itemsList.getStringList(blockBroken.getType().name().toUpperCase()).forEach((String Drop) -> {
                    int DropAmount = Integer.parseInt(Drop.split(":")[1]);
                    Material dropBlock = Material.valueOf(Drop.split(":")[0]);

                    blockBroken.getWorld().dropItem(blockBroken.getLocation(), new ItemStack(dropBlock, DropAmount));
                });
            } else if (config.getBoolean("BDR.randomizeEachDrop")) {
                if (blacklistedBlocks.size() > 0) {
                    ArrayList<Object> fixedList = new ArrayList<>(Arrays.asList(Arrays.stream(Material.values()).toArray()));
                    blacklistedBlocks.forEach(fixedList::remove);
                    Object[] FinalList = fixedList.stream().filter((M) -> {
                        Material MM = Material.valueOf(M.toString());
                        return MM.isItem() && MM != Material.AIR;
                    }).toArray();
                    int RandomNumber = new Random().nextInt(FinalList.length);
                    blockBroken.getWorld().dropItem(blockBroken.getLocation(), new ItemStack(Material.valueOf(FinalList[RandomNumber].toString())));
                } else {
                    Object[] FinalList = Arrays.stream(allItems).filter((M) -> {
                        Material MM = Material.valueOf(M.toString());
                        return MM.isItem() && MM != Material.AIR;
                    }).toArray();
                    int RandomNumber = new Random().nextInt(FinalList.length);
                    blockBroken.getWorld().dropItem(blockBroken.getLocation(), new ItemStack(Material.valueOf(FinalList[RandomNumber].toString())));
                }
            } else if (!config.getBoolean("BDR.randomizeEachDrop")) {
                if (pluginConfig != null && pluginConfig.contains(blockBroken.getType().name())) {
                   blockBroken.getWorld().dropItem(blockBroken.getLocation(), new ItemStack(Material.valueOf(pluginConfig.getString(blockBroken.getType().name().toUpperCase())), 1));
                } else {
                    if (blacklistedBlocks.size() > 0) {
                        ArrayList<Object> fixedList = new ArrayList<>(Arrays.asList(Arrays.stream(Material.values()).toArray()));
                        blacklistedBlocks.forEach(fixedList::remove);
                        Object[] FinalList = fixedList.stream().filter((M) -> {
                            Material MM = Material.valueOf(M.toString());
                            return MM.isItem() && MM != Material.AIR;
                        }).toArray();
                        int RandomNumber = new Random().nextInt(FinalList.length);

                        blockBroken.getWorld().dropItem(blockBroken.getLocation(), new ItemStack(Material.valueOf(FinalList[RandomNumber].toString())));
                        pluginConfig.set(blockBroken.getType().name().toUpperCase(), FinalList[RandomNumber].toString());
                        CustomConfigHandler.Save();
                    } else {
                        Object[] FinalList = Arrays.stream(allItems).filter((M) -> {
                            Material MM = Material.valueOf(M.toString());
                            return MM.isItem() && MM != Material.AIR;
                        }).toArray();
                        int RandomNumber = new Random().nextInt(FinalList.length);
                        pluginConfig.set(blockBroken.getType().name().toUpperCase(), FinalList[RandomNumber].toString());
                        CustomConfigHandler.Save();
                        blockBroken.getWorld().dropItem(blockBroken.getLocation(), new ItemStack(Material.valueOf(FinalList[RandomNumber].toString())));
                    }
                }
            }

    }

}
