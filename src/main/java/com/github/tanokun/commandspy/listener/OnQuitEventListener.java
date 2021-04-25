package com.github.tanokun.commandspy.listener;

import com.github.tanokun.commandspy.command.CommandSpyCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnQuitEventListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        CommandSpyCommand.flag.remove(e.getPlayer());
    }
}
