package constants;

public interface TypeItem{


    enum TypeEquipment implements TypeItem {
        ARMOR, MAGIC_HAT, WEAPON;
    }

    enum TypePotion implements TypeItem{

        HP, MP;
    }

}
