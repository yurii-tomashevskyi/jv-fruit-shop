package shop.strategy;

import shop.db.Storage;
import shop.impl.FruitTransaction;
import shop.model.Fruit;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getFruitName());
        int oldAmount = Storage.fruitsCount.getOrDefault(fruit, 0);
        int newAmount = oldAmount + fruitTransaction.getQuantity();
        Storage.fruitsCount.put(fruit, newAmount);
    }
}
