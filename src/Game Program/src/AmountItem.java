public class AmountItem {

    int amount;
    Item item;

    public AmountItem(int amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "AmountItem{" +
                "amount=" + amount +
                ", item=" + item +
                '}';
    }
}
