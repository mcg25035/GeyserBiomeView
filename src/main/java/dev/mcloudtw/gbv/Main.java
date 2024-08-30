package dev.mcloudtw.gbv;

import dev.mcloudtw.gbv.commands.BiomeViewCommand;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public final class Main extends JavaPlugin {
    public static HashSet<Player> enabledBiomeView  = new HashSet<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            Bukkit.getOnlinePlayers().forEach(player -> {
                Biome biome = player.getLocation().getBlock().getBiome();
                if (!enabledBiomeView.contains(player)) return;
                player.sendActionBar(MiniMessage.miniMessage().deserialize(
                        "<gray>生態域</gray>: <white>" + biome.name()
                ));
            });
        }, 0, 20);
        BiomeViewCommand.command().register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
