package com.github.tanokun.commandspy.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandSpyCommand implements CommandExecutor {
    public static ArrayList<Player> flag = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        if (!flag.contains(p)){
            flag.add(p);
            sender.sendMessage("§aCommandSpy is enabled");
        } else {
            flag.remove(p);
            sender.sendMessage("§aCommandSpy is disabled");
        }
        return true;
    }
}
