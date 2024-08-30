package dev.mcloudtw.gbv.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.mcloudtw.gbv.Main;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class BiomeViewCommand {
    public static CommandAPICommand command() {
        return new CommandAPICommand("biomeview")
                .executesPlayer((player, args) -> {
                    if (Main.enabledBiomeView.contains(player)) {
                        Main.enabledBiomeView.remove(player);
                        player.sendMessage(
                                MiniMessage.miniMessage().deserialize("<gray>[<gold>生態</gold>]</gray> <red>生態域顯示已關閉")
                        );
                    } else {
                        Main.enabledBiomeView.add(player);
                        player.sendMessage(
                                MiniMessage.miniMessage().deserialize("<gray>[<gold>生態</gold>]</gray> <green>生態域顯示已開啟")
                        );
                    }
                });
    }
}
