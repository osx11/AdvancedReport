package com.osx11.osx11;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CommandReport implements CommandExecutor {

    private Main plugin;

    public CommandReport(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length < 2 || args.length > 3) return false;

        String player = args[0];
        String reason = args[1];
        String proof;

        if (args.length > 2) proof = args[2];
        else proof = "Proof not found";

        File f = new File(plugin.getDataFolder() + File.separator + "reports.yml");
        FileConfiguration reports = YamlConfiguration.loadConfiguration(f);

        try {
            if (reports.getConfigurationSection("reports").getKeys(false).toArray().length > 26) {
                sender.sendMessage(plugin.getConfig().getString("messages.MoreThan27Reports").replace("&", "§"));
                return true;
            }
        } catch (NullPointerException e) {}

        if (reports.getString("reports." + player) != null) {
            sender.sendMessage(plugin.getConfig().getString("messages.PlayerAlreadyReported").replace("&", "§"));
            return true;
        }

        reports.set("reports." + player, player);
        reports.set("reports." + player + ".reason", reason);
        reports.set("reports." + player + ".by", sender.getName());
        reports.set("reports." + player + ".proof", proof);

        try {
            reports.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sender.sendMessage(plugin.getConfig().getString("messages.ReportedSuccessfully").replace("&", "§").replace("%player%", player));
        Bukkit.broadcast(plugin.getConfig().getString("messages.CreateReportNotify").replace("&", "§").replace("%player%", sender.getName()), "advancedreport.notify");
        return true;
    }
}
