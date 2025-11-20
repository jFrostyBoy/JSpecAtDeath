package jfbdev.jspecatdeath.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class JSpecAtDeathReturnCommand implements CommandExecutor {

    private final JavaPlugin plugin;
    public JSpecAtDeathReturnCommand(JavaPlugin plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        String prefix = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("prefix", ""));

        String soundName = plugin.getConfig().getString("sounds.return.sound", "entity.player.levelup");
        float volume = (float) plugin.getConfig().getDouble("sounds.return.volume", 1.0);
        float pitch = (float) plugin.getConfig().getDouble("sounds.return.pitch", 1.0);

        if (commandSender instanceof Player player) {
            if (!player.hasPermission("jspecatdeath.return")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        prefix + plugin.getConfig().getString("messages.no-permission", "")));
                return true;
            }

            if (args.length != 1) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        prefix + plugin.getConfig().getString("messages.usage.return", "")));
                return true;
            }

            var target = plugin.getServer().getPlayerExact(args[0]);
            if (target == null || !target.isOnline()) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        prefix + plugin.getConfig().getString("messages.not-found", "")));
                return true;
            }

            if (target.getGameMode() != GameMode.SPECTATOR) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        prefix + plugin.getConfig().getString("messages.not-spectator", ""))
                        .replace("%player%", target.getName()));
                return true;
            }

            target.setGameMode(GameMode.SURVIVAL);
            target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 400, 0, true, true, true));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    prefix + plugin.getConfig().getString("messages.returned", "")));
            target.playSound(target.getLocation(), soundName, volume, pitch);
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    prefix + plugin.getConfig().getString("messages.returned-player", ""))
                    .replace("%player%", target.getName()));
            player.playSound(player.getLocation(), soundName, volume, pitch);
            return true;

        }
        return true;
    }
}
