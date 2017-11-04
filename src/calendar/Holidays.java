/**
 * @author Lukas Wiest
 */
package calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Holidays
{

    public static enum DAY_CLASS
    {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY,
        NEWYEAR,
        HOLY_THREE_KINGS,
        GOOD_FRIDAY,
        EASTER_SUNDAY,
        EASTER_MONDAY,
        CHRIST_ASCESION,
        PENTECOST_SUNDAY,
        PENTECOST_MONDAY,
        CORPUS_CHRISTI,
        LABOUR_DAY,
        ASSUMPTION_DAY,
        UNIFICATION_DAY,
        REFORMATION_DAY,
        ALL_SAINTS_DAY,
        PRAYER_REPENTANCE,
        CHRISTMAS_EVE,
        CHRISTMAS_1ST,
        CHRISTMAS_2ND,
        NEWYEARS_EVE
    }

    public static Holidays.DAY_CLASS classifyWeekday(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        switch(cal.get(Calendar.DAY_OF_WEEK))
        {
            case Calendar.MONDAY:
                return Holidays.DAY_CLASS.MONDAY;
            case Calendar.TUESDAY:
                return Holidays.DAY_CLASS.TUESDAY;
            case Calendar.WEDNESDAY:
                return Holidays.DAY_CLASS.WEDNESDAY;
            case Calendar.THURSDAY:
                return Holidays.DAY_CLASS.THURSDAY;
            case Calendar.FRIDAY:
                return Holidays.DAY_CLASS.FRIDAY;
            case Calendar.SATURDAY:
                return Holidays.DAY_CLASS.SATURDAY;
            default:
                return Holidays.DAY_CLASS.SUNDAY;
        }
    }

    public static Holidays.DAY_CLASS classifyHoliday(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        switch(cal.get(Calendar.MONTH))
        {
            case Calendar.JANUARY:
                switch (cal.get(Calendar.DAY_OF_MONTH))
                {
                    case 1:
                        return Holidays.DAY_CLASS.NEWYEAR;
                    case 6:
                        return Holidays.DAY_CLASS.HOLY_THREE_KINGS;
                }
                break;

            case Calendar.MAY:
                switch (cal.get(Calendar.DAY_OF_MONTH))
                {
                    case 1:
                        return Holidays.DAY_CLASS.LABOUR_DAY;
                }
                break;

            case Calendar.AUGUST:
                switch (cal.get(Calendar.DAY_OF_MONTH))
                {
                    case 15:
                        return Holidays.DAY_CLASS.ASSUMPTION_DAY;
                }
                break;

            case Calendar.OCTOBER:
                switch (cal.get(Calendar.DAY_OF_MONTH))
                {
                    case 3:
                        return Holidays.DAY_CLASS.UNIFICATION_DAY;
                    case 31:
                        return Holidays.DAY_CLASS.REFORMATION_DAY;
                }
                break;

            case Calendar.NOVEMBER:
                switch (cal.get(Calendar.DAY_OF_MONTH))
                {
                    case 1:
                        return Holidays.DAY_CLASS.ALL_SAINTS_DAY;
                    case 25:
                        return Holidays.DAY_CLASS.PRAYER_REPENTANCE;
                }
                break;

            case Calendar.DECEMBER:
                switch (cal.get(Calendar.DAY_OF_MONTH))
                {
                    case 24:
                        return Holidays.DAY_CLASS.CHRISTMAS_EVE;
                    case 25:
                        return Holidays.DAY_CLASS.CHRISTMAS_1ST;
                    case 26:
                        return Holidays.DAY_CLASS.CHRISTMAS_2ND;
                    case 31:
                        return Holidays.DAY_CLASS.NEWYEARS_EVE;
                }
                break;
        }

        Calendar    easterSunday    = Calendar.getInstance();
        Calendar    easterMonday    = Calendar.getInstance();
        Calendar    goodFriday      = Calendar.getInstance();
        Calendar    christAscesion  = Calendar.getInstance();
        Calendar    pentecostSunday = Calendar.getInstance();
        Calendar    pentecostMonday = Calendar.getInstance();
        Calendar    corpusChristi   = Calendar.getInstance();
        DateFormat  df              = new SimpleDateFormat("dd-MM-yyyy");
        int         easterSundayInt = easterSunday(cal.get(Calendar.YEAR));

        try
        {
            if (easterSundayInt > 31)
            {
                easterSunday.setTime(df.parse(((easterSundayInt - 31) + "-04-" + cal.get(Calendar.YEAR))));
            }
            else
            {
                easterSunday.setTime(df.parse((easterSundayInt + "-03-" + cal.get(Calendar.YEAR))));
            }
        }
        catch (ParseException e)
        {
        }

        easterMonday.setTime(easterSunday.getTime());
        easterMonday.add(Calendar.DATE, 1);

        goodFriday.setTime(easterSunday.getTime());
        goodFriday.add(Calendar.DATE, -2);

        christAscesion.setTime(easterSunday.getTime());
        christAscesion.add(Calendar.DATE, 39);

        pentecostSunday.setTime(easterSunday.getTime());
        pentecostSunday.add(Calendar.DATE, 49);

        pentecostMonday.setTime(pentecostSunday.getTime());
        pentecostMonday.add(Calendar.DATE, 1);

        corpusChristi.setTime(pentecostSunday.getTime());
        corpusChristi.add(Calendar.DATE, 11);

        if (cal.getTime().equals(easterSunday.getTime()))
        {
            return Holidays.DAY_CLASS.EASTER_SUNDAY;
        }
        else if (cal.getTime().equals(easterMonday.getTime()))
        {
            return Holidays.DAY_CLASS.EASTER_MONDAY;
        }
        else if (cal.getTime().equals(goodFriday.getTime()))
        {
            return Holidays.DAY_CLASS.GOOD_FRIDAY;
        }
        else if (cal.getTime().equals(christAscesion.getTime()))
        {
            return Holidays.DAY_CLASS.CHRIST_ASCESION;
        }
        else if (cal.getTime().equals(pentecostSunday.getTime()))
        {
            return Holidays.DAY_CLASS.PENTECOST_SUNDAY;
        }
        else if (cal.getTime().equals(pentecostMonday.getTime()))
        {
            return Holidays.DAY_CLASS.PENTECOST_MONDAY;
        }
        else if (cal.getTime().equals(corpusChristi.getTime()))
        {
            return Holidays.DAY_CLASS.CORPUS_CHRISTI;
        }

        Calendar prayerRepentanceDay = prayerRepentanceDay(cal.get(Calendar.YEAR));
        if (prayerRepentanceDay.getTime().equals(cal.getTime()))
        {
            return Holidays.DAY_CLASS.PRAYER_REPENTANCE;
        }

        return null;
    }

    static int easterSunday(int X)
    {
        final int K = X / 100;
        final int M = 15 + (3*K +3) / 4 - (8*K + 13) / 25;
        final int S = 2 - (3*K + 3) / 4;
        final int A = X % 19;
        final int D = (19*A + M) % 30;
        final int R = (D + A / 11) / 29;
        final int OG = 21 + D - R;
        final int SZ = 7 - (X + X / 4 + S) % 7;
        final int OE = 7 - (OG - SZ) % 7;
        final int OS = OG + OE;

        return OS;
    }

    private static Calendar prayerRepentanceDay(int X)
    {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar christmas = Calendar.getInstance();
        try
        {
            christmas.setTime(df.parse("24-12-" + X));
        }
        catch (ParseException e)
        {
            return null;
        }

        Calendar result = Calendar.getInstance();
        result.setTime(christmas.getTime());
        result.add(Calendar.DATE, -32);
        result.add(Calendar.DATE, -(christmas.get(Calendar.DAY_OF_WEEK) - 1));

        return result;
    }
}
