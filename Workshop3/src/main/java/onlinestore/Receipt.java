package onlinestore;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private float receiptTotal;
    private List<Game> receiptItems;

    public Receipt(List<Game> receiptItems) {
        this.receiptItems = new ArrayList<>(receiptItems);
    }

    public float getReceiptTotal() {
        receiptTotal = 0;
        for(Game game : receiptItems){
            receiptTotal += game.getPrice();
        }
        return receiptTotal;
    }

    public List<Game> getReceiptItems() {
        return receiptItems;
    }

    public void setReceiptItems(List<Game> receiptItems) {
        this.receiptItems = receiptItems;
    }

    public void addGame(Game game){
        receiptItems.add(game);
    }

    public void removeGame(Game game){
        receiptItems.remove(game);
    }

}
