package seedu.delino.testutil;

import seedu.delino.model.ReturnOrderBook;
import seedu.delino.model.parcel.returnorder.ReturnOrder;

//@@author Exeexe93
/**
 * A utility class to help with building ReturnOrderbook objects.
 * Example usage: <br>
 *     {@code ReturnOrderBook ab = new ReturnOrderBookBuilder().withReturnOrder("John", "Doe").build();}
 */
public class ReturnOrderBookBuilder {

    private ReturnOrderBook orderBook;

    public ReturnOrderBookBuilder() {
        orderBook = new ReturnOrderBook();
    }

    public ReturnOrderBookBuilder(ReturnOrderBook orderBook) {
        this.orderBook = orderBook;
    }

    /**
     * Adds a new {@code Order} to the {@code OrderBook} that we are building.
     */
    public ReturnOrderBookBuilder withReturnOrder(ReturnOrder returnOrder) {
        orderBook.addReturnOrder(returnOrder);
        return this;
    }

    public ReturnOrderBook build() {
        return orderBook;
    }
}
