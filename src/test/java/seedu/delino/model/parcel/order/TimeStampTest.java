package seedu.delino.model.parcel.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.delino.model.parcel.parcelattributes.TimeStamp.REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW;
import static seedu.delino.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.delino.model.parcel.parcelattributes.TimeStamp;

//@@author Exeexe93
class TimeStampTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TimeStamp(null, REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW));
    }

    @Test
    public void constructor_invalidTimeStamp_throwsIllegalArgumentException() {
        String invalidDateOnly = "2019-20-02";
        String invalidTimeOnly = "0213";
        String invalidDate = "2019-02-29 2000";
        String invalidTime = "2020-02-20 2512";
        String timestampBeforeNow = "2020-02-01 1200";
        assertThrows(IllegalArgumentException.class, () -> new TimeStamp(invalidDateOnly,
                REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW));
        assertThrows(IllegalArgumentException.class, () -> new TimeStamp(invalidTimeOnly,
                REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW));
        assertThrows(IllegalArgumentException.class, () -> new TimeStamp(invalidDate,
                REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW));
        assertThrows(IllegalArgumentException.class, () -> new TimeStamp(invalidTime,
                REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW));
        assertThrows(IllegalArgumentException.class, () -> new TimeStamp(timestampBeforeNow,
                REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW));
    }

    @Test
    public void checkTimestamp_allInvalidTimestamp_giveCorrectOutput() {
        String invalidDateOnly = "2019-20-02";
        String invalidTimeOnly = "0213";
        String invalidDate = "2021-02-29 2000";
        String invalidTime = "2021-02-20 2512";
        String timeBeforeCurrent = "2020-04-03 2000";

        // null timeStamp
        assertThrows(NullPointerException.class, () -> TimeStamp.checkTimestamp(null,
                REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW));

        // invalid timeStamp
        assertEquals(TimeStamp.checkTimestamp("", REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW),
                TimeStamp.PARSE_ERROR); // empty string
        assertEquals(TimeStamp.checkTimestamp(" ", REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW),
                TimeStamp.PARSE_ERROR); // spaces only
        assertEquals(TimeStamp.checkTimestamp(invalidDateOnly, REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW),
                TimeStamp.PARSE_ERROR); // date only
        assertEquals(TimeStamp.checkTimestamp(invalidTimeOnly, REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW),
                TimeStamp.PARSE_ERROR); // time only
        assertEquals(TimeStamp.checkTimestamp(invalidDate, REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW),
                TimeStamp.PARSE_ERROR); // invalid date
        assertEquals(TimeStamp.checkTimestamp(invalidTime, REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW),
                TimeStamp.PARSE_ERROR); // invalid time
        assertEquals(TimeStamp.checkTimestamp(timeBeforeCurrent, REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW),
                TimeStamp.TIMESTAMP_BEFORE_NOW_ERROR);

    }

    @Test
    public void checkTimestamp_validTimestamp_giveCorrectOutput() {
        String validInput = "2022-05-20 1500";

        // valid timeStamp
        assertEquals(TimeStamp.checkTimestamp(validInput, REQUIRE_CHECK_IF_TIMESTAMP_BEFORE_NOW),
                TimeStamp.VALID_TIMESTAMP);
    }
}
