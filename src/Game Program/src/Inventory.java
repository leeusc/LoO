import constants.TypeItem;

import java.util.List;
import java.util.Objects;

import static constants.TypeItem.TypeEquipment.ARMOR;

public class Inventory {

    int maxStorage = 4;
    List<AmountItem> amountItems;

    public String openInventory(){
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (AmountItem amountItem: amountItems){
            sb.append(++index + ". ").append(amountItem.item.getName()).append(" (" + amountItem.amount + ")").append("\n");
        }
        return sb.toString();
    }


    public void addNewItem(Item item){
        if (amountStorage() >= maxStorage){
            return;
        }

        for (AmountItem existItem : amountItems){
            if (item.equals(existItem.item)){
                existItem.amount += 1;
                return;
            }
        }

        AmountItem newItem = new AmountItem(1, item);
        amountItems.add(newItem);
    }

    public void removeItem(Item item){

        for (int i = 0; i < amountItems.size(); i++){
            AmountItem itemExist = amountItems.get(i);
            if (item == itemExist.getItem()) {
                if (itemExist.getAmount() == 1){
                    amountItems.remove(itemExist);
                }else if (itemExist.getAmount() > 1){
                    itemExist.amount -= 1;
                }
                return;
            }
        }
    }




















    public int amountStorage(){
        int counter = 0;
        for (AmountItem amountItem: amountItems){
            counter += amountItem.getAmount();
        }
        return counter;
    }

    public int getMaxStorage() {
        return maxStorage;
    }

    public void setMaxStorage(int maxStorage) {
        this.maxStorage = maxStorage;
    }

    public List<AmountItem> getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(List<AmountItem> amountItems) {
        this.amountItems = amountItems;
    }



    @Override
    public String toString() {
        return "Inventory{" +
                "maxStorage=" + maxStorage +
                ", amountItems=" + amountItems +
                '}';
    }
}
