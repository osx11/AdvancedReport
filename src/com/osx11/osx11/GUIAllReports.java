package com.osx11.osx11;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class GUIAllReports implements CommandExecutor {

    private Main plugin;

    public GUIAllReports(Main plugin) {
        this.plugin = plugin;
    }

    private static String[] reportedPlayer = new String[27];

    public String[] getReportedPlayer() {
        return reportedPlayer;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getConfig().getString("messages.ForPlayersOnly").replace("&", "§"));
            return true;
        }

        if (args.length != 0) return false;

        Player player = Bukkit.getPlayer(sender.getName());
        openGUIReports(player);
        return true;
    }

    public void openGUIReports(Player player) {
        try {
            File f = new File(plugin.getDataFolder() + File.separator + "reports.yml");
            FileConfiguration reports = YamlConfiguration.loadConfiguration(f);

            Inventory inventory = Bukkit.createInventory(null, 27, plugin.getConfig().getString("messages.GUIAllReportsName").replace("&", "§"));

            int itemNumber = reports.getConfigurationSection("reports").getKeys(false).toArray().length;
            int totalNumber = 27; // всего
            int itemNumber2 = -1; // сколько надо отнять
            int itemNumber3; // сколько раз повторить цикл
            String[] reason = new String[27];
            String[] displayItem = new String[27];

            // Преобразовываем массив ников Objects в массив String
            System.arraycopy(reports.getConfigurationSection("reports").getKeys(false).toArray(), 0, reportedPlayer, 0 , itemNumber);

            for (int i = 0; i < itemNumber; i++) { // Set displayItem
                displayItem[i] = plugin.getConfig().getString("playerReportDisplayItem");
                itemNumber2++;
            }

            itemNumber3 = totalNumber - itemNumber2 - 1;

            /*for (int i = 0; i < itemNumber; i++) // Get ban reasons
                reason[i] = plugin.getConfig().getString("banreasons." + i + ".reason").replace("&", "§");*/

            for (int i = 0; i < itemNumber3; i++) { // Если игроков в списке меньше 9
                displayItem[itemNumber] = "AIR";
                itemNumber++;
            }

            // ---------------------------------------------------------------------------------------------------------

            ItemStack reason1 = new ItemStack(Material.valueOf(displayItem[0]));
            ItemMeta reason1Meta = reason1.getItemMeta();

            ItemStack reason2 = new ItemStack(Material.valueOf(displayItem[1]), 2);
            ItemMeta reason2Meta = reason2.getItemMeta();

            ItemStack reason3 = new ItemStack(Material.valueOf(displayItem[2]), 3);
            ItemMeta reason3Meta = reason3.getItemMeta();

            ItemStack reason4 = new ItemStack(Material.valueOf(displayItem[3]), 4);
            ItemMeta reason4Meta = reason4.getItemMeta();

            ItemStack reason5 = new ItemStack(Material.valueOf(displayItem[4]), 5);
            ItemMeta reason5Meta = reason5.getItemMeta();

            ItemStack reason6 = new ItemStack(Material.valueOf(displayItem[5]), 6);
            ItemMeta reason6Meta = reason6.getItemMeta();

            ItemStack reason7 = new ItemStack(Material.valueOf(displayItem[6]), 7);
            ItemMeta reason7Meta = reason7.getItemMeta();

            ItemStack reason8 = new ItemStack(Material.valueOf(displayItem[7]), 8);
            ItemMeta reason8Meta = reason8.getItemMeta();

            ItemStack reason9 = new ItemStack(Material.valueOf(displayItem[8]), 9);
            ItemMeta reason9Meta = reason2.getItemMeta();

            ItemStack reason10 = new ItemStack(Material.valueOf(displayItem[9]), 10);
            ItemMeta reason10Meta = reason3.getItemMeta();

            ItemStack reason11 = new ItemStack(Material.valueOf(displayItem[10]), 11);
            ItemMeta reason11Meta = reason4.getItemMeta();

            ItemStack reason12 = new ItemStack(Material.valueOf(displayItem[11]), 12);
            ItemMeta reason12Meta = reason5.getItemMeta();

            ItemStack reason13 = new ItemStack(Material.valueOf(displayItem[12]), 13);
            ItemMeta reason13Meta = reason6.getItemMeta();

            ItemStack reason14 = new ItemStack(Material.valueOf(displayItem[13]), 14);
            ItemMeta reason14Meta = reason7.getItemMeta();

            ItemStack reason15 = new ItemStack(Material.valueOf(displayItem[14]), 15);
            ItemMeta reason15Meta = reason8.getItemMeta();

            ItemStack reason16 = new ItemStack(Material.valueOf(displayItem[15]), 16);
            ItemMeta reason16Meta = reason2.getItemMeta();

            ItemStack reason17 = new ItemStack(Material.valueOf(displayItem[16]), 17);
            ItemMeta reason17Meta = reason3.getItemMeta();

            ItemStack reason18 = new ItemStack(Material.valueOf(displayItem[17]), 18);
            ItemMeta reason18Meta = reason4.getItemMeta();

            ItemStack reason19 = new ItemStack(Material.valueOf(displayItem[18]), 19);
            ItemMeta reason19Meta = reason5.getItemMeta();

            ItemStack reason20 = new ItemStack(Material.valueOf(displayItem[19]), 20);
            ItemMeta reason20Meta = reason6.getItemMeta();

            ItemStack reason21 = new ItemStack(Material.valueOf(displayItem[20]), 21);
            ItemMeta reason21Meta = reason7.getItemMeta();

            ItemStack reason22 = new ItemStack(Material.valueOf(displayItem[21]), 22);
            ItemMeta reason22Meta = reason8.getItemMeta();

            ItemStack reason23 = new ItemStack(Material.valueOf(displayItem[22]), 23);
            ItemMeta reason23Meta = reason7.getItemMeta();

            ItemStack reason24 = new ItemStack(Material.valueOf(displayItem[23]), 24);
            ItemMeta reason24Meta = reason8.getItemMeta();

            ItemStack reason25 = new ItemStack(Material.valueOf(displayItem[24]), 25);
            ItemMeta reason25Meta = reason8.getItemMeta();

            ItemStack reason26 = new ItemStack(Material.valueOf(displayItem[25]), 26);
            ItemMeta reason26Meta = reason8.getItemMeta();

            ItemStack goBack = new ItemStack(Material.BARRIER);
            ItemMeta goBackMeta = goBack.getItemMeta();

            // ---------------------------------------------------------------------------------------------------------

            try {
                reason1Meta.setDisplayName(reportedPlayer[0]);
                reason1.setItemMeta(reason1Meta);

                reason2Meta.setDisplayName(reportedPlayer[1]);
                reason2.setItemMeta(reason2Meta);

                reason3Meta.setDisplayName(reportedPlayer[2]);
                reason3.setItemMeta(reason3Meta);

                reason4Meta.setDisplayName(reportedPlayer[3]);
                reason4.setItemMeta(reason4Meta);

                reason5Meta.setDisplayName(reportedPlayer[4]);
                reason5.setItemMeta(reason5Meta);

                reason6Meta.setDisplayName(reportedPlayer[5]);
                reason6.setItemMeta(reason6Meta);

                reason7Meta.setDisplayName(reportedPlayer[6]);
                reason7.setItemMeta(reason7Meta);

                reason8Meta.setDisplayName(reportedPlayer[7]);
                reason8.setItemMeta(reason8Meta);

                reason9Meta.setDisplayName(reportedPlayer[8]);
                reason9.setItemMeta(reason9Meta);

                reason10Meta.setDisplayName(reportedPlayer[9]);
                reason10.setItemMeta(reason10Meta);

                reason11Meta.setDisplayName(reportedPlayer[10]);
                reason11.setItemMeta(reason11Meta);

                reason12Meta.setDisplayName(reportedPlayer[11]);
                reason12.setItemMeta(reason12Meta);

                reason13Meta.setDisplayName(reportedPlayer[12]);
                reason13.setItemMeta(reason13Meta);

                reason14Meta.setDisplayName(reportedPlayer[13]);
                reason14.setItemMeta(reason14Meta);

                reason15Meta.setDisplayName(reportedPlayer[14]);
                reason15.setItemMeta(reason15Meta);

                reason16Meta.setDisplayName(reportedPlayer[15]);
                reason16.setItemMeta(reason16Meta);

                reason17Meta.setDisplayName(reportedPlayer[16]);
                reason17.setItemMeta(reason17Meta);

                reason18Meta.setDisplayName(reportedPlayer[17]);
                reason18.setItemMeta(reason18Meta);

                reason19Meta.setDisplayName(reportedPlayer[18]);
                reason19.setItemMeta(reason19Meta);

                reason20Meta.setDisplayName(reportedPlayer[19]);
                reason20.setItemMeta(reason20Meta);

                reason21Meta.setDisplayName(reportedPlayer[20]);
                reason21.setItemMeta(reason21Meta);

                reason22Meta.setDisplayName(reportedPlayer[21]);
                reason22.setItemMeta(reason22Meta);

                reason23Meta.setDisplayName(reportedPlayer[22]);
                reason23.setItemMeta(reason23Meta);

                reason24Meta.setDisplayName(reportedPlayer[23]);
                reason24.setItemMeta(reason24Meta);

                reason25Meta.setDisplayName(reportedPlayer[24]);
                reason25.setItemMeta(reason25Meta);

                reason26Meta.setDisplayName(reportedPlayer[25]);
                reason26.setItemMeta(reason26Meta);

                goBackMeta.setDisplayName((plugin.getConfig().getString("messages.GUIGoBack").replace("&", "§")));
                goBack.setItemMeta(goBackMeta);
            } catch (Exception e) {}

            // ---------------------------------------------------------------------------------------------------------

            inventory.setItem(0, reason1);
            inventory.setItem(1, reason2);
            inventory.setItem(2, reason3);
            inventory.setItem(3, reason4);
            inventory.setItem(4, reason5);
            inventory.setItem(5, reason6);
            inventory.setItem(6, reason7);
            inventory.setItem(7, reason8);
            inventory.setItem(8, reason9);
            inventory.setItem(9, reason10);
            inventory.setItem(10, reason11);
            inventory.setItem(11, reason12);
            inventory.setItem(12, reason13);
            inventory.setItem(13, reason14);
            inventory.setItem(14, reason15);
            inventory.setItem(15, reason16);
            inventory.setItem(16, reason17);
            inventory.setItem(17, reason18);
            inventory.setItem(18, reason19);
            inventory.setItem(19, reason20);
            inventory.setItem(20, reason21);
            inventory.setItem(21, reason22);
            inventory.setItem(22, reason23);
            inventory.setItem(23, reason24);
            inventory.setItem(24, reason25);
            inventory.setItem(25, reason26);
            inventory.setItem(26, goBack);

            player.openInventory(inventory);
        } catch (NullPointerException e) {
            player.sendMessage(plugin.getConfig().getString("messages.NoReportsFound").replace("&", "§"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
