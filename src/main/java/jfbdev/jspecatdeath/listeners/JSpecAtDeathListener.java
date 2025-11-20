package jfbdev.jspecatdeath.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JSpecAtDeathListener implements Listener {

    private final JavaPlugin plugin;
    public JSpecAtDeathListener(JavaPlugin plugin) { this.plugin = plugin; }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        String soundName = plugin.getConfig().getString("sounds.death.sound", "entity.wither.spawn");
        float volume = (float) plugin.getConfig().getDouble("sounds.death.volume", 1.0);
        float pitch = (float) plugin.getConfig().getDouble("sounds.death.pitch", 1.0);

        player.setGameMode(GameMode.SPECTATOR);
        plugin.getConfig().getStringList("messages.death-notice")
                        .forEach(line ->
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', line)));

        player.playSound(player.getLocation(), soundName, volume, pitch);
    }
}
