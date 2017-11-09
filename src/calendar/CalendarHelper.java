/**
 * Created by Classdumper, User Peter Heusch
 * Creation Date: 21.10.2017 10:05:26
 */
package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarHelper {

    public static void main(String[] args) {
        Calendar start = createCalendar(5, 8, 2017);
        Calendar expected = createCalendar(16, 8, 2017);
        Calendar result = getDayOf(start, 0, 12);

        System.out.println(result.getTime());
    }

    public static Calendar createCalendar(int day, int month, int year) {
        GregorianCalendar ca = new GregorianCalendar(year, (month - 1), day);
        return ca;
    }

    public static int getCalWeekYear(Calendar cal) {
        return cal.getWeekYear();
    }

    public static Calendar getDayOf(Calendar month, int day, int count) {
        int monat = month.get(Calendar.MONTH);
        int jahr = month.get(Calendar.YEAR);
        int start = 1 + day;
        month = createCalendar(start, monat + 1, jahr);
        for (int i = 1; i < count; i++) {
            if (month.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                    || month.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                i--;
            }
            if (month.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                    || month.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                System.out.println(month.get(Calendar.DAY_OF_WEEK));
                int ubergabe = month.get(Calendar.DAY_OF_MONTH);
                month = createCalendar(ubergabe + 1, monat + 1, jahr);
            }
        }
        return month;
    }

    public static int getThursday(Calendar cal) {
        return cal.get(Calendar.THURSDAY);
    }

    public static Calendar[] getDayRange(Calendar start, Calendar pauseFrom, Calendar pauseTo, int count, int step) {
        // Roughly 17 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static int getCalWeekWeek(Calendar cal) {
        return cal.get(Calendar.WEEK_OF_MONTH);
    }
}
