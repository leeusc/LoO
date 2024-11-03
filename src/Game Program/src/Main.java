import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static constants.TypeItem.TypeEquipment.WEAPON;

public class Main {

    public static void main(String[] args) {
        //
        Player player = new Player(100, 100, 50, 50, 10);
        Inventory inventory = new Inventory();
        List<AmountItem> amountItems = new ArrayList<>();
        amountItems.add(new AmountItem(1, new ItemEquipment("general weapon", 17, WEAPON)));
        inventory.setAmountItems(amountItems);
        player.setInventory(inventory);
        //


        System.out.println(player.printStatusPlayer());
        System.out.println("BEFORE");

        // Items' Farming
        Item farming = player.Farming();
        Item farming2 = player.Farming();
        Item farming3 = player.Farming();
        Item farming4 = player.Farming();
        Item farming5 = player.Farming();
        Item farming6 = player.Farming();

        player.inventory.addNewItem(farming);
        player.inventory.addNewItem(farming2);
        player.inventory.addNewItem(farming3);
        player.inventory.addNewItem(farming4);
        player.inventory.addNewItem(farming5);
        player.inventory.addNewItem(farming6);
        //
        System.out.println(inventory.openInventory());

        // AFTER USED ITEM
        player.usedItem("general weapon");
        System.out.println(inventory.openInventory());
        System.out.println(player.printStatusPlayer());
    }
}
