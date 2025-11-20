package jfbdev.jspecatdeath.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class JSpecAtDeathReloadCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public JSpecAtDeathReloadCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        String prefix = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("prefix", ""));

        if (commandSender instanceof Player player) {
            if (!player.hasPermission("jspecatdeath.reload")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        prefix + plugin.getConfig().getString("messages.no-permission", "")));
                return true;
            }

            if (args.length != 0) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        prefix + plugin.getConfig().getString("messages.usage.reload", "")));
                return true;
            }
        }

        plugin.reloadConfig();
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                prefix + plugin.getConfig().getString("messages.reloaded", "")));
        return true;
    }
}