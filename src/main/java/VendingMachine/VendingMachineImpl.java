package VendingMachine;

import java.util.List;

public class VendingMachineImpl{// implements VendingMachine {
    /*private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Item> itemInventory = new Inventory<Item>();
    private long totalSales; private Item currentItem;
    private long currentBalance;

    VendingMachineImpl(){
        initialize();
    }

    private void initialize(){
        //initialize machine with 5 coins of each denomination
        // and 5 cans of each Item
        for(Coin c : Coin.values())
        {
            cashInventory.put(c, 5);
        }
        for(Item i : Item.values())
        {
            itemInventory.put(i, 5);
        }

    }


    @Override
    public long selectItemAndGetPrice(Item item) {
        if(itemInventory.hasItem(item)){
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Sold Out, Please buy another item");

    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change = collectChange();
        return new Bucket<Item, List<Coin>>(item, change);

    }

    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException{
        if(isFullPaid())
        {
            if(hasSufficientChange())
            {
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not Sufficient change in Inventory");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : ", remainingBalance);
    }
    private List<Coin> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    private boolean isFullPaid() {
        if(currentBalance >= currentItem.getPrice()){
            return true;
        }
        return false;
    }

    @Override
    public void reset() {

    }*/
}
