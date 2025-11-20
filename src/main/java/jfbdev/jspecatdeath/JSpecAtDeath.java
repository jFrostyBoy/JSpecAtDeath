package jfbdev.jspecatdeath;

import jfbdev.jspecatdeath.commands.JSpecAtDeathReloadCommand;
import jfbdev.jspecatdeath.commands.JSpecAtDeathReturnCommand;
import jfbdev.jspecatdeath.listeners.JSpecAtDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class JSpecAtDeath extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();
        Objects.requireNonNull(getCommand("jsadreload")).setExecutor(new JSpecAtDeathReloadCommand(this));
        Objects.requireNonNull(getCommand("jsadreturn")).setExecutor(new JSpecAtDeathReturnCommand(this));
        getServer().getPluginManager().registerEvents(new JSpecAtDeathListener(this), this);

    }
}
