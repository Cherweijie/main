package seedu.delino.model.parcel.order;

import static java.util.Objects.requireNonNull;
import static seedu.delino.commons.util.AppUtil.checkArgument;

/**
 * Represents the cash to be earned by courier for this order in the order list.
 * Guarantees: immutable; is valid as declared in {@link #isValidCashValue(String)}
 */
public class CashOnDelivery {
    public static final String MESSAGE_CONSTRAINTS =
            "Please put a dollar sign before the money value and make sure that \n"
                    + "the value must be below the amount $10,000,000,000,000\n"
                    + "(If there is a need to add decimal values, the amount can only accept"
                    + "exactly two decimal places)";

    /*
     * Must have a $ sign followed by the value
     */
    public static final String VALIDATION_REGEX = "^\\$\\d{1,13}(?:[.]\\d{2})?$";

    public final String cashOnDelivery;

    /**
     * Constructs a {@code CashOnDelivery}.
     *
     * @param cashOnDelivery A valid cash value.
     */
    public CashOnDelivery(String cashOnDelivery) {
        requireNonNull(cashOnDelivery);
        checkArgument(isValidCashValue(cashOnDelivery), MESSAGE_CONSTRAINTS);
        this.cashOnDelivery = cashOnDelivery;
    }

    /**
     * Returns true if a given string is a valid cash value.
     */
    public static boolean isValidCashValue(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public double getCashValue() {
        return Double.parseDouble(cashOnDelivery.substring(1));
    }
    @Override
    public String toString() {
        return cashOnDelivery;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CashOnDelivery // instanceof handles nulls
                && cashOnDelivery.equals(((CashOnDelivery) other).cashOnDelivery)); // state check
    }

    @Override
    public int hashCode() {
        return cashOnDelivery.hashCode();
    }

}
