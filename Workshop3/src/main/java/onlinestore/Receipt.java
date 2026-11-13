package onlinestore;

import java.util.List;

public class Receipt {

    private float receiptTotal;
    private List<Game> receiptItems;

    public Receipt(List<Game> receiptItems) {
        this.receiptItems = receiptItems;
    }

    public float getReceiptTotal() {
        return receiptTotal;
    }



    public List<Game> getReceiptItems() {
        return receiptItems;
    }

    public void setReceiptItems(List<Game> receiptItems) {
        this.receiptItems = receiptItems;
    }

    // methods

        // confirmEnough (make sure the users entered cash amount is equal to or greater than this.amount)
            // if so printReceipt(), else return to user they dont have enough funds
        // print receipt


}
