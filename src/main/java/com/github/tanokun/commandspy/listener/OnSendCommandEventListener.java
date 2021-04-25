package com.github.tanokun.commandspy.listener;

import com.github.tanokun.commandspy.CommandSpy;
import com.github.tanokun.commandspy.command.CommandSpyCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


public class OnSendCommandEventListener implements Listener {
    @EventHandler
    public void onQuit(PlayerCommandPreprocessEvent e){
        CommandSpyCommand.flag.stream().forEach(player ->
            player.sendMessage(CommandSpy.getMessage(e.getPlayer(), e.getMessage()))
        );
    }
}