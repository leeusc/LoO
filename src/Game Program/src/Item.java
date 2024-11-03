import constants.TypeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static constants.TypeItem.TypeEquipment.*;
import static constants.TypeItem.TypePotion.HP;
import static constants.TypeItem.TypePotion.MP;

public abstract class Item {

    String name;
    TypeItem typeItem;

    public Item(String name) {
        this.name = name;
    }

    static public List<Item> dataDummy(){
        Item weapon1 = new ItemEquipment("weapon1", 10, WEAPON);
        Item magicHat1 = new ItemEquipment("magicHat1",10, MAGIC_HAT);
        Item armor1 = new ItemEquipment("armor1", 10, ARMOR);

        Item hp1 = new ItemPotion("hp1", 20, HP);
        Item mp1 = new ItemPotion("mp1", 20, MP);

        List<Item> itemList = new ArrayList<>();
        itemList.add(weapon1);
        itemList.add(magicHat1);
        itemList.add(armor1);
        itemList.add(hp1);
        itemList.add(mp1);
        return itemList;
    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())return false;

        Item item = (Item) o;
        return this.name.equals(item.name) && this.typeItem == item.typeItem;
    }

    public int getBuff(){
        return 0;
    }








    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeItem getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(TypeItem typeItem) {
        this.typeItem = typeItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
