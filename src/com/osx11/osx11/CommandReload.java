package com.osx11.osx11;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReload implements CommandExecutor {

    private Main plugin;

    public CommandReload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length != 0) return false;

        plugin.reloadConfig();
        sender.sendMessage(plugin.getConfig().getString("messages.ConfigReload").replace("&", "§"));
        return true;
    }
}
