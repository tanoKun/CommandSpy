package com.github.tanokun.commandspy;

import com.github.tanokun.commandspy.command.CommandSpyCommand;
import com.github.tanokun.commandspy.listener.OnQuitEventListener;
import com.github.tanokun.commandspy.listener.OnSendCommandEventListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandSpy extends JavaPlugin {
    private static String message;

    public void onEnable() {
        getLogger().info(ChatColor.GREEN + "Pluginが有効化されました。");

        Bukkit.getPluginCommand("commandspy").setExecutor(new CommandSpyCommand());

        Bukkit.getPluginManager().registerEvents(new OnQuitEventListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnSendCommandEventListener(), this);

        setupConfig();
    }

    public void onDisable() {
        getLogger().info(ChatColor.RED + "Pluginが無効化されました。");
    }

    private void setupConfig(){
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        message = config.getString("CommandMessage", "&7%playerName% &a: &7%command%");
    }

    public static String getMessage(Player sender, String command) {
        String newMessage = message;
        newMessage = newMessage.replaceAll("&", "§");
        newMessage = newMessage.replaceAll("%playerName%", sender.getName());
        newMessage = newMessage.replaceAll("%command%", command);
        return newMessage;
    }
}
