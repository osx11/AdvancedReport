// §

package com.osx11.osx11;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        // Create config.yml and reports.yml files
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            getLogger().info("Creating new config file...");
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }

        File reports = new File(getDataFolder() + File.separator + "reports.yml");
        if (!reports.exists()) {
            getLogger().info("Creating new reports file...");
            try {
                reports.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Initialize commands
        getCommand("arreload").setExecutor(new CommandReload(this));
        getCommand("report").setExecutor(new CommandReport(this));
        getCommand("reports").setExecutor(new GUIAllReports(this));

        getServer().getPluginManager().registerEvents(this,this);
        getLogger().info("---------- AdvancedReport LOADED SUCCESSFULLY ----------");
    }

    public void onDisable() {

    }

    private GUISpecifiedReport guiSpecifiedReport = new GUISpecifiedReport(this);
    private GUIAllReports guiAllReports = new GUIAllReports(this);
    private GUIBanReasons9 guiBanReasons9 = new GUIBanReasons9(this);
    private GUIBanReasons18 guiBanReasons18 = new GUIBanReasons18(this);
    private GUIBanReasons27 guiBanReasons27 = new GUIBanReasons27(this);

    private String reportedPlayerClicked; // Запоминает на какой слот чел кликнул при выборе репорта (надо для возврата из GUIBanReasons в GUISpecifiedReport)

    @EventHandler
    public void onClickGUIAllReports(InventoryClickEvent event) { // GUI Ban reasons
        if (!event.getInventory().getName().equalsIgnoreCase(getConfig().getString("messages.GUIAllReportsName").replace("&", "§"))) {
            return;
        }
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

        try {
            switch (event.getCurrentItem().getType()) {
                case BARRIER:
                    player.closeInventory();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {}

        try {
            switch (event.getSlot()) {
                case 0:
                    if (event.getCurrentItem().getAmount() == 1) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[0]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[0];
                    }
                    break;
                case 1:
                    if (event.getCurrentItem().getAmount() == 2) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[1]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[1];
                    }
                    break;
                case 2:
                    if (event.getCurrentItem().getAmount() == 3) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[2]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[2];
                    }
                    break;
                case 3:
                    if (event.getCurrentItem().getAmount() == 4) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[3]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[3];
                    }
                    break;
                case 4:
                    if (event.getCurrentItem().getAmount() == 5) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[4]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[4];
                    }
                    break;
                case 5:
                    if (event.getCurrentItem().getAmount() == 6) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[5]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[5];
                    }
                    break;
                case 6:
                    if (event.getCurrentItem().getAmount() == 7) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[6]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[6];
                    }
                    break;
                case 7:
                    if (event.getCurrentItem().getAmount() == 8) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[7]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[7];
                    }
                    break;
                case 8:
                    if (event.getCurrentItem().getAmount() == 9) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[9]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[9];
                    }
                    break;
                case 9:
                    if (event.getCurrentItem().getAmount() == 10) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[0]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[0];
                    }
                    break;
                case 10:
                    if (event.getCurrentItem().getAmount() == 11) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[10]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[10];
                    }
                    break;
                case 11:
                    if (event.getCurrentItem().getAmount() == 12) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[11]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[11];
                    }
                    break;
                case 12:
                    if (event.getCurrentItem().getAmount() == 13) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[12]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[12];
                    }
                    break;
                case 13:
                    if (event.getCurrentItem().getAmount() == 14) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[13]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[13];
                    }
                    break;
                case 14:
                    if (event.getCurrentItem().getAmount() == 15) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[14]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[14];
                    }
                    break;
                case 15:
                    if (event.getCurrentItem().getAmount() == 16) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[15]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[15];
                    }
                    break;
                case 16:
                    if (event.getCurrentItem().getAmount() == 17) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[16]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[16];
                    }
                    break;
                case 17:
                    if (event.getCurrentItem().getAmount() == 18) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[17]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[17];
                    }
                    break;
                case 18:
                    if (event.getCurrentItem().getAmount() == 19) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[18]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[18];
                    }
                    break;
                case 19:
                    if (event.getCurrentItem().getAmount() == 20) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[19]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[19];
                    }
                    break;
                case 20:
                    if (event.getCurrentItem().getAmount() == 21) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[20]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[20];
                    }
                    break;
                case 21:
                    if (event.getCurrentItem().getAmount() == 22) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[21]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[21];
                    }
                    break;
                case 22:
                    if (event.getCurrentItem().getAmount() == 23) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[22]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[22];
                    }
                    break;
                case 23:
                    if (event.getCurrentItem().getAmount() == 24) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[23]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[23];
                    }
                    break;
                case 24:
                    if (event.getCurrentItem().getAmount() == 25) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[24]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[24];
                    }
                    break;
                case 25:
                    if (event.getCurrentItem().getAmount() == 26) {
                        player.closeInventory();
                        guiSpecifiedReport.getReportedPlayerData(player, guiAllReports.getReportedPlayer()[25]);
                        reportedPlayerClicked = guiAllReports.getReportedPlayer()[25];
                    }
                    break;
                default: break;
            }
        } catch (Exception e) {}
    }

    @EventHandler
    public void onClickGUISpecifiedReport(InventoryClickEvent event) { // GUI Specified report
        if (!event.getInventory().getName().equalsIgnoreCase(getConfig().getString("messages.GUISpecifiedReportName").replace("&", "§"))) {
            return;
        }
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

        try {
            switch (event.getCurrentItem().getType()) {
                case PAPER:
                    player.sendMessage(getConfig().getString("messages.HereIsAProof").replace("&", "§").replace("%proof%", guiSpecifiedReport.getReportProof()));
                    player.closeInventory();
                    break;
                case STRUCTURE_VOID:
                    guiSpecifiedReport.deleteReport(player);
                    player.closeInventory();
                    guiAllReports.openGUIReports(player);
                    break;
                case BOW:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick " + guiSpecifiedReport.getReportPlayer() + " " + guiSpecifiedReport.getReportReason());
                    player.closeInventory();
                    break;
                case MOB_SPAWNER:
                    player.closeInventory();
                    int itemNumber = getConfig().getConfigurationSection("banreasons").getKeys(false).toArray().length;
                    if (itemNumber <= 9) guiBanReasons9.openGUIBanReasons(player);
                    else if (itemNumber <= 18) guiBanReasons18.openGUIBanReasons(player);
                    else if (itemNumber <= 27) guiBanReasons27.openGUIBanReasons(player);
                    else if (itemNumber > 27) {
                        player.sendMessage(getConfig().getString("messages.MoreThan27Slots").replace("&", "§"));
                        break;
                    } else {
                        player.sendMessage(getConfig().getString("messages.Error").replace("&", "§"));
                        break;
                    }
                    break;
                case DIAMOND_SWORD:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill " + guiSpecifiedReport.getReportPlayer());
                    player.closeInventory();
                    break;
                case BARRIER:
                    player.closeInventory();
                    guiAllReports.openGUIReports(player);
                    break;
                default: break;
            }
        } catch (Exception e) {}
    }

    @EventHandler
    public void onClickGUIBanReasons(InventoryClickEvent event) { // GUI Ban reasons
        if (!event.getInventory().getName().equalsIgnoreCase(getConfig().getString("messages.GUIBanReasonsName").replace("&", "§"))) {
            return;
        }
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);

        try {
            switch (event.getCurrentItem().getType()) {
                case BARRIER:
                    player.closeInventory();
                    guiSpecifiedReport.getReportedPlayerData(player, reportedPlayerClicked);
                    break;
                default: break;
            }
        } catch (Exception e) {}

        try {
            switch (event.getSlot()) {
                case 0:
                    if (event.getCurrentItem().getAmount() == 1) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.0.time") + " :" + getConfig().getString("banreasons.0.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 1:
                    if (event.getCurrentItem().getAmount() == 2) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.1.time") + " :" + getConfig().getString("banreasons.1.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 2:
                    if (event.getCurrentItem().getAmount() == 3) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.2.time") + " :" + getConfig().getString("banreasons.2.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 3:
                    if (event.getCurrentItem().getAmount() == 4) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.3.time") + " :" + getConfig().getString("banreasons.3.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 4:
                    if (event.getCurrentItem().getAmount() == 5) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.4.time") + " :" + getConfig().getString("banreasons.4.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 5:
                    if (event.getCurrentItem().getAmount() == 6) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.5.time") + " :" + getConfig().getString("banreasons.5.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 6:
                    if (event.getCurrentItem().getAmount() == 7) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.6.time") + " :" + getConfig().getString("banreasons.6.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 7:
                    if (event.getCurrentItem().getAmount() == 8) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.7.time") + " :" + getConfig().getString("banreasons.7.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 8:
                    if (event.getCurrentItem().getAmount() == 9) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.8.time") + " :" + getConfig().getString("banreasons.8.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 9:
                    if (event.getCurrentItem().getAmount() == 10) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.9.time") + " :" + getConfig().getString("banreasons.9.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 10:
                    if (event.getCurrentItem().getAmount() == 11) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.10.time") + " :" + getConfig().getString("banreasons.10.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 11:
                    if (event.getCurrentItem().getAmount() == 12) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.11.time") + " :" + getConfig().getString("banreasons.11.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 12:
                    if (event.getCurrentItem().getAmount() == 13) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.12.time") + " :" + getConfig().getString("banreasons.12.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 13:
                    if (event.getCurrentItem().getAmount() == 14) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.13.time") + " :" + getConfig().getString("banreasons.13.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 14:
                    if (event.getCurrentItem().getAmount() == 15) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.14.time") + " :" + getConfig().getString("banreasons.14.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 15:
                    if (event.getCurrentItem().getAmount() == 16) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.15.time") + " :" + getConfig().getString("banreasons.15.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 16:
                    if (event.getCurrentItem().getAmount() == 17) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.16.time") + " :" + getConfig().getString("banreasons.16.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 17:
                    if (event.getCurrentItem().getAmount() == 18) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.17.time") + " :" + getConfig().getString("banreasons.17.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 18:
                    if (event.getCurrentItem().getAmount() == 19) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.0.time") + " :" + getConfig().getString("banreasons.18.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 19:
                    if (event.getCurrentItem().getAmount() == 20) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.1.time") + " :" + getConfig().getString("banreasons.19.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 20:
                    if (event.getCurrentItem().getAmount() == 21) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.2.time") + " :" + getConfig().getString("banreasons.20.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 21:
                    if (event.getCurrentItem().getAmount() == 22) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.3.time") + " :" + getConfig().getString("banreasons.21.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 22:
                    if (event.getCurrentItem().getAmount() == 23) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.4.time") + " :" + getConfig().getString("banreasons.22.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 23:
                    if (event.getCurrentItem().getAmount() == 24) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.5.time") + " :" + getConfig().getString("banreasons.23.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 24:
                    if (event.getCurrentItem().getAmount() == 25) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.6.time") + " :" + getConfig().getString("banreasons.24.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                case 25:
                    if (event.getCurrentItem().getAmount() == 26) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + guiSpecifiedReport.getReportPlayer() + " " + getConfig().getString("banreasons.7.time") + " :" + getConfig().getString("banreasons.25.reason"));
                        player.closeInventory();
                        guiSpecifiedReport.deleteReport(player);
                        guiAllReports.openGUIReports(player);
                    }
                    break;
                default: break;
            }
        } catch (Exception e) {}
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (getConfig().getBoolean("settings.EnableJoinMessage")) {
            Player player = event.getPlayer();
            if (player.hasPermission("advancedreport.*"))
                player.sendMessage(getConfig().getString("messages.JoinMessage").replace("&", "§"));
        }
    }
}
