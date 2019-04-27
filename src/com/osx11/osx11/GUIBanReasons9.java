package com.osx11.osx11;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIBanReasons9{

    private Main plugin;

    public GUIBanReasons9(Main plugin) {
        this.plugin = plugin;
    }

    public void openGUIBanReasons(Player player) {
        try {
            Inventory inventory = Bukkit.createInventory(null, 9, plugin.getConfig().getString("messages.GUIBanReasonsName").replace("&", "§"));

            int itemNumber = plugin.getConfig().getConfigurationSection("banreasons").getKeys(false).toArray().length;
            int totalNumber = 9; // всего
            int itemNumber2 = -1; // сколько надо отнять
            int itemNumber3; // сколько раз повторить цикл
            String[] displayItem = new String[9];
            String[] reason = new String[9];

            for (int i = 0; i < itemNumber; i++) { // Get display item
                displayItem[i] = plugin.getConfig().getString("banreasons." + i + ".displayItem");
                itemNumber2++;
            }

            itemNumber3 = totalNumber - itemNumber2 - 1;

            for (int i = 0; i < itemNumber; i++) // Get ban reasons
                reason[i] = plugin.getConfig().getString("banreasons." + i + ".reason").replace("&", "§");

            for (int i = 0; i < itemNumber3; i++) { // Если прични для бана в конфиге меньше 9
                displayItem[itemNumber] = "AIR";
                reason[itemNumber] = plugin.getConfig().getString("messages.ReasonNotFound").replace("&", "§");
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

            ItemStack goBack = new ItemStack(Material.BARRIER);
            ItemMeta goBackMeta = goBack.getItemMeta();

            // ---------------------------------------------------------------------------------------------------------

            try {
                reason1Meta.setDisplayName(reason[0]);
                reason1.setItemMeta(reason1Meta);

                reason2Meta.setDisplayName(reason[1]);
                reason2.setItemMeta(reason2Meta);

                reason3Meta.setDisplayName(reason[2]);
                reason3.setItemMeta(reason3Meta);

                reason4Meta.setDisplayName(reason[3]);
                reason4.setItemMeta(reason4Meta);

                reason5Meta.setDisplayName(reason[4]);
                reason5.setItemMeta(reason5Meta);

                reason6Meta.setDisplayName(reason[5]);
                reason6.setItemMeta(reason6Meta);

                reason7Meta.setDisplayName(reason[6]);
                reason7.setItemMeta(reason7Meta);

                reason8Meta.setDisplayName(reason[7]);
                reason8.setItemMeta(reason8Meta);

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
            inventory.setItem(8, goBack);

            player.openInventory(inventory);
        } catch (Exception e) {
            player.sendMessage("Exception3: " + e);
            e.printStackTrace();
        }
    }
}
