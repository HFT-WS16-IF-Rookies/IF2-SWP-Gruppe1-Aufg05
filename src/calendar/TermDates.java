/**
 * Created by Classdumper, User Peter Heusch
 * Creation Date: 21.10.2017 10:05:26
 */

package calendar;

import de.hft_stuttgart.unittest.loader.Skeleton;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Skeleton
public class TermDates {
    static {
        System.err.println("Please call injectClass(\"calendar.TermDates\"), you've imported a skeleton");
    }

    public static final String INVALID_TERM_START = "Invalid term start.";

    public TermDates() {
        // Roughly 1 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void setDate(Calendar cal, Date date) {
        // Roughly 4 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static List<List<Date>> getTermDates(Date dateBegin) {
        // Roughly 4 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static List<List<Date>> getDatesBetween(Date begin, Date end) {
        // Roughly 18 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

