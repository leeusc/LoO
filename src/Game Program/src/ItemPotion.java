import constants.TypeItem;

public class ItemPotion extends Item{

        int healAmount;
        TypeItem.TypePotion typePotion;

    public ItemPotion(String name, int healAmount, TypeItem.TypePotion typePotion) {
        super(name);
        this.healAmount = healAmount;
        this.typePotion = typePotion;
    }

    public int getBuff() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public TypeItem.TypePotion getTypePotion() {
        return typePotion;
    }

    public void setTypePotion(TypeItem.TypePotion typePotion) {
        this.typePotion = typePotion;
    }

    @Override
    public String toString() {
        return "[Type: " + typePotion + ", name: " + super.getName() + ", buff: " + getBuff() + "]";
    }
}
