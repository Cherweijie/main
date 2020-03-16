package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.comment.Comment;
import seedu.address.model.order.Address;
import seedu.address.model.order.CashOnDelivery;
import seedu.address.model.order.Name;
import seedu.address.model.order.Order;
import seedu.address.model.order.Phone;
import seedu.address.model.order.TransactionId;
import seedu.address.model.order.TimeStamp;
import seedu.address.model.order.Warehouse;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Order objects.
 */
public class OrderBuilder {

    public static final String DEFAULT_TID = "A98765431";
    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_TIMESTAMP = "2020-02-20 1500";
    public static final String DEFAULT_WAREHOUSE = "5 Toh Guan Rd E, #02-30 S608831";
    public static final String DEFAULT_COD = "$3";
    public static final String DEFAULT_COMMENT = "NIL";

    private TransactionId tid;
    private Name name;
    private Phone phone;
    private Address address;
    private TimeStamp timeStamp;
    private Warehouse warehouse;
    private CashOnDelivery cod;
    private Comment comment;
    private Set<Tag> tags;

    public OrderBuilder() {
        tid = new TransactionId(DEFAULT_TID);
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        address = new Address(DEFAULT_ADDRESS);
        timeStamp = new TimeStamp(DEFAULT_TIMESTAMP);
        warehouse = new Warehouse(DEFAULT_WAREHOUSE);
        cod = new CashOnDelivery(DEFAULT_COD);
        comment = new Comment(DEFAULT_COMMENT);
        tags = new HashSet<>();
    }

    /**
     * Initializes the OrderBuilder with the data of {@code orderToCopy}.
     */
    public OrderBuilder(Order orderToCopy) {
        tid = orderToCopy.getTid();
        name = orderToCopy.getName();
        phone = orderToCopy.getPhone();
        address = orderToCopy.getAddress();
        timeStamp = orderToCopy.getTimestamp();
        warehouse = orderToCopy.getWarehouse();
        cod = orderToCopy.getCash();
        comment = orderToCopy.getComment();
        tags = new HashSet<>(orderToCopy.getTags());
    }

    /**
     * Sets the {@code TransactionID} of the {@code Order} that we are building.
     */
    public OrderBuilder withCash(String cod) {
        this.cod = new CashOnDelivery(cod);
        return this;
    }

    /**
     * Sets the {@code TransactionID} of the {@code Order} that we are building.
     */
    public OrderBuilder withTID(String tid) {
        this.tid = new TransactionId(tid);
        return this;
    }

    /**
     * Sets the {@code Name} of the {@code Order} that we are building.
     */
    public OrderBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Order} that we are building.
     */
    public OrderBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Order} that we are building.
     */
    public OrderBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code TimeStamp} of the {@code Order} that we are building.
     */
    public OrderBuilder withTimeStamp(String timeStamp) {
        this.timeStamp = new TimeStamp(timeStamp);
        return this;
    }

    /**
     * Sets the {@code Warehouse} of the {@code Order} that we are building.
     */
    public OrderBuilder withWarehouse(String warehouseLocation) {
        this.warehouse = new Warehouse(warehouseLocation);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Order} that we are building.
     */
    public OrderBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Comment} of the {@code Order} that we are building.
     */
    public OrderBuilder withComment(String comment) {
        this.comment = new Comment(comment);
        return this;
    }

    public Order build() {
        return new Order(tid, name, phone, address, timeStamp, warehouse, cod, comment, tags);
    }

}
