import constants.TypeItem;

public class ItemEquipment extends Item{

    int incrementAmount;
    TypeItem.TypeEquipment typeEquipment;

    public ItemEquipment(String name, int incrementAmount, TypeItem.TypeEquipment typeEquipment) {
        super(name);
        this.incrementAmount = incrementAmount;
        this.typeEquipment = typeEquipment;
    }

    public int getBuff() {
        return incrementAmount;
    }

    public void setIncrementAmount(int incrementAmount) {
        this.incrementAmount = incrementAmount;
    }

    public TypeItem.TypeEquipment getTypeEquipment() {
        return typeEquipment;
    }

    public void setTypeEquipment(TypeItem.TypeEquipment typeEquipment) {
        this.typeEquipment = typeEquipment;
    }

    @Override
    public String toString() {
        return "[Type: " + typeEquipment + ", name: " + super.getName() + ", buff: " + getBuff() + "]";
    }
}
