import constants.TypeItem;

import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import static constants.TypeItem.TypeEquipment.*;
import static constants.TypeItem.TypePotion.HP;
import static constants.TypeItem.TypePotion.MP;

public class Player {

    int currentHealth = 0;
    int maxHealth;
    int currentEnergy;
    int maxEnergy;
    int damage;
    Inventory inventory;

    public Player(int currentHealth, int maxHealth, int currentEnergy, int maxEnergy, int damage) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.currentEnergy = currentEnergy;
        this.maxEnergy = maxEnergy;
        this.damage = damage;
    }

    public String printStatusPlayer(){
        StringBuilder sb = new StringBuilder("STATUS\n");
        sb.append("Current Health: ").append(currentHealth).append("\n");
        sb.append("Max Health: ").append(maxHealth).append("\n");
        sb.append("Current Energy: ").append(currentEnergy).append("\n");
        sb.append("Max Energy: ").append(maxEnergy).append("\n");
        sb.append("Damage: ").append(damage).append("\n");
        return sb.toString();
    }

    public Item Farming(){
        List<Item> itemList = Item.dataDummy();

        int index = new Random().nextInt(itemList.size());
        Item random = itemList.get(index);
        itemList.remove(random);
        return random;
    }


    public void usedItem(String itemName){
        if (inventory.getAmountItems() == null){
            return;
        }

        for (AmountItem existItem : inventory.getAmountItems()){

            // item name matches with existing item
            if (itemName.equals(existItem.getItem().getName())){
                Item item = existItem.getItem();

                // EQUIPMENT
                if (item instanceof ItemEquipment){
                    // type of EQUIPMENT
                    TypeItem typeEquip = ((ItemEquipment) item).getTypeEquipment();

                    if (typeEquip == ARMOR){
                            maxHealth += item.getBuff();
                    }else if (typeEquip == MAGIC_HAT){
                            maxEnergy += item.getBuff();
                    }else if (typeEquip == WEAPON){
                            damage += item.getBuff();
                    }

                //POTION
                }else if (item instanceof ItemPotion){
                    //type of POTION
                    TypeItem typePotion = ((ItemPotion) item).getTypePotion();

                    if (typePotion == HP){
                        currentHealth += item.getBuff();
                    }else if (typePotion == MP){
                        currentEnergy += item.getBuff();
                    }
                }
                inventory.removeItem(item);
                return;
            }
        }
    }























    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return
                "Inventory: " + inventory;
    }
}
