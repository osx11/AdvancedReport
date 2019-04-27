package com.osx11.osx11;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUISpecifiedReport {

    private Main plugin;

    public GUISpecifiedReport(Main plugin) {
        this.plugin = plugin;
    }

    private static String reportPlayer;
    private static String reportReason;
    private String reportBy;
    private static String reportProof;

    public String getReportPlayer() {
        return reportPlayer;
    }
    public String getReportReason() {
        return reportReason;
    }
    public String getReportProof() {
        return reportProof;
    }

    // Get reported player data (such as reason, by, proof)
    public void getReportedPlayerData(Player sender, String player) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getConfig().getString("messages.ForPlayersOnly").replace("&", "§"));
            return;
        }

        reportPlayer = player;

        File file = new File(plugin.getDataFolder() + File.separator + "reports.yml");
        FileConfiguration players = YamlConfiguration.loadConfiguration(file);

        if (players.getString("reports." + reportPlayer) == null) {
            sender.sendMessage(plugin.getConfig().getString("messages.PlayerNotFound").replace("&", "§"));
            return;
        }

        reportReason = players.getString("reports." + reportPlayer + ".reason");
        reportBy = players.getString("reports." + reportPlayer + ".by");
        reportProof = players.getString("reports." + reportPlayer + ".proof");

        openGUISpecifiedReport(Bukkit.getPlayer(sender.getName()));
    }

    // -----------------------------------------------------------------------------------------------------------------

    // Delete report
    public void deleteReport(Player player) {
        File file = new File(plugin.getDataFolder() + File.separator + "reports.yml");
        FileConfiguration players = YamlConfiguration.loadConfiguration(file);

        players.set("reports." + reportPlayer, null);

        try {
            players.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.sendMessage(plugin.getConfig().getString("messages.ReportDeleted").replace("&", "§"));
        Bukkit.broadcast(plugin.getConfig().getString("messages.ReportDeletedNotify").replace("&","§").replace("%commandExecutor%", player.getName()).replace("%player%", reportPlayer),"advancedreport.notify");
    }

    private void openGUISpecifiedReport(Player player) {
        // Create new inventory
        Inventory inventory = Bukkit.createInventory(null, 9, plugin.getConfig().getString("messages.GUISpecifiedReportName").replace("&", "§"));

        ItemStack reportedBy = new ItemStack(Material.PAPER); // Reported by
        ItemMeta reportedByMeta = reportedBy.getItemMeta();

        ItemStack reportedReason = new ItemStack(Material.PAPER); // Reported reason
        ItemMeta reportedReasonMeta = reportedReason.getItemMeta();

        ItemStack deleteReport = new ItemStack(Material.STRUCTURE_VOID); // Delete report
        ItemMeta deleteReportMeta = deleteReport.getItemMeta();

        ItemStack kickPlayer = new ItemStack(Material.BOW); // Kick player
        ItemMeta kickPlayerMeta = kickPlayer.getItemMeta();

        ItemStack banPlayer = new ItemStack(Material.MOB_SPAWNER); // Ban player
        ItemMeta banPlayerMeta = banPlayer.getItemMeta();

        ItemStack teleportToPlayer = new ItemStack(Material.DIAMOND_SWORD); // Kill player
        ItemMeta teleportToPlayerMeta = teleportToPlayer.getItemMeta();

        ItemStack goBack = new ItemStack(Material.BARRIER); // Close GUI
        ItemMeta goBackMeta = goBack.getItemMeta();

        // -------------------------------------------------------------------------------------------------------------

        List<String> reportedReasonLore = new ArrayList<>();
        List<String> banPlayerLore = new ArrayList<>();
        reportedReasonLore.add(0, plugin.getConfig().getString("messages.GetProof").replace("&", "§"));
        banPlayerLore.add(0, plugin.getConfig().getString("messages.BanWarning").replace("&", "§"));

        // -------------------------------------------------------------------------------------------------------------

        reportedByMeta.setDisplayName(plugin.getConfig().getString("messages.ReportedBy").replace("&", "§").replace("%player%", reportPlayer).replace("%reportedBy%", reportBy)); // Reported by
        reportedBy.setItemMeta(reportedByMeta);

        reportedReasonMeta.setDisplayName(plugin.getConfig().getString("messages.ReportReason").replace("&", "§").replace("%reportReason%", reportReason)); // Reported reason
        reportedReasonMeta.setLore(reportedReasonLore);
        reportedReason.setItemMeta(reportedReasonMeta);

        deleteReportMeta.setDisplayName(plugin.getConfig().getString("messages.DeleteReport").replace("&", "§")); // Delete report
        deleteReport.setItemMeta(deleteReportMeta);

        kickPlayerMeta.setDisplayName(plugin.getConfig().getString("messages.KickPlayer").replace("&", "§")); // Kick player
        kickPlayer.setItemMeta(kickPlayerMeta);

        banPlayerMeta.setDisplayName(plugin.getConfig().getString("messages.BanPlayer").replace("&", "§")); // Ban player
        banPlayerMeta.setLore(banPlayerLore);
        banPlayer.setItemMeta(banPlayerMeta);

        teleportToPlayerMeta.setDisplayName(plugin.getConfig().getString("messages.KillPlayer").replace("&", "§")); // Kill player
        teleportToPlayer.setItemMeta(teleportToPlayerMeta);

        goBackMeta.setDisplayName(plugin.getConfig().getString("messages.GUIGoBack").replace("&", "§")); // Close GUI
        goBack.setItemMeta(goBackMeta);

        inventory.setItem(0, reportedBy);
        inventory.setItem(1, reportedReason);
        inventory.setItem(3, deleteReport);
        inventory.setItem(4, kickPlayer);
        inventory.setItem(5, banPlayer);
        inventory.setItem(6, teleportToPlayer);
        inventory.setItem(8, goBack);

        player.openInventory(inventory);
    }
}
