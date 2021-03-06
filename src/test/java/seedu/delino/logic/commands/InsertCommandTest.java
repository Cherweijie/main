package seedu.delino.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.delino.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.delino.commons.core.GuiSettings;
import seedu.delino.logic.commands.exceptions.CommandException;
import seedu.delino.model.Model;
import seedu.delino.model.OrderBook;
import seedu.delino.model.ReadOnlyOrderBook;
import seedu.delino.model.ReadOnlyReturnOrderBook;
import seedu.delino.model.ReadOnlyUserPrefs;
import seedu.delino.model.parcel.Parcel;
import seedu.delino.model.parcel.order.Order;
import seedu.delino.model.parcel.returnorder.ReturnOrder;
import seedu.delino.testutil.OrderBuilder;

//@author Amoscheong97
/**
 * Insert Command Testing
 *
 */
public class InsertCommandTest {

    @Test
    public void constructor_nullOrder_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new InsertCommand(null));
    }

    @Test
    public void execute_orderAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingOrderAdded modelStub = new ModelStubAcceptingOrderAdded();
        Order validOrder = new OrderBuilder().build();

        CommandResult commandResult = new InsertCommand(validOrder).execute(modelStub);

        assertEquals(String.format(InsertCommand.MESSAGE_SUCCESS, validOrder), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validOrder), modelStub.ordersAdded);
    }

    @Test
    public void execute_duplicateOrder_throwsCommandException() {
        Order validOrder = new OrderBuilder().build();
        InsertCommand insertCommand = new InsertCommand(validOrder);
        ModelStub modelStub = new ModelStubWithOrder(validOrder);

        assertThrows(CommandException.class,
                InsertCommand.MESSAGE_DUPLICATE_ORDER, () -> insertCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Order alice = new OrderBuilder().withName("Alice").build();
        Order bob = new OrderBuilder().withName("Bob").build();
        InsertCommand insertAliceCommand = new InsertCommand(alice);
        InsertCommand insertBobCommand = new InsertCommand(bob);

        // same object -> returns true
        assertTrue(insertAliceCommand.equals(insertAliceCommand));

        // same values -> returns true
        InsertCommand insertAliceCommandCopy = new InsertCommand(alice);
        assertTrue(insertAliceCommand.equals(insertAliceCommandCopy));

        // different types -> returns false
        assertFalse(insertAliceCommand.equals(1));

        // null -> returns false
        assertFalse(insertAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(insertAliceCommand.equals(insertBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getOrderBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setOrderBookFilePath(Path orderBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addOrder(Order order) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setOrderBook(ReadOnlyOrderBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyOrderBook getOrderBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteOrder(Order target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setOrder(Order target, Order editedOrder) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deliverOrder(Order target) {
            throw new AssertionError("This method should not be called.");
        }
        @Override
        public void deliverReturnOrder(ReturnOrder target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getReturnOrderBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setReturnOrderBookFilePath(Path orderBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addReturnOrder(ReturnOrder returnOrder) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setReturnOrderBook(ReadOnlyReturnOrderBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyReturnOrderBook getReturnOrderBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteReturnOrder(ReturnOrder target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setReturnOrder(ReturnOrder target, ReturnOrder editedOrder) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Order> getFilteredOrderList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<ReturnOrder> getFilteredReturnOrderList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredOrderList(Predicate<Order> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredReturnOrderList(Predicate<ReturnOrder> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasParcel(Parcel parcel) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public List<String> getStartUpMessages() {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single order.
     */
    private class ModelStubWithOrder extends ModelStub {
        private final Order order;

        ModelStubWithOrder(Order order) {
            requireNonNull(order);
            this.order = order;
        }

        @Override
        public boolean hasParcel(Parcel parcel) {
            requireNonNull(parcel);
            return this.order.isSameParcel(order);
        }
    }

    /**
     * A Model stub that always accept the order being added.
     */
    private class ModelStubAcceptingOrderAdded extends ModelStub {
        final ArrayList<Order> ordersAdded = new ArrayList<>();

        @Override
        public boolean hasParcel(Parcel parcel) {
            requireNonNull(parcel);
            return ordersAdded.stream().anyMatch(parcel::isSameParcel);
        }

        @Override
        public void addOrder(Order order) {
            requireNonNull(order);
            ordersAdded.add(order);
        }

        @Override
        public ReadOnlyOrderBook getOrderBook() {
            return new OrderBook();
        }
    }

}
