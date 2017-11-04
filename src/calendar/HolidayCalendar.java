/**
 * @author Lukas Wiest
 */
package calendar;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import static calendar.Holidays.*;
import java.util.Calendar;

public class HolidayCalendar
{

    private Properties properties;

    public HolidayCalendar(String uri) throws IOException
    {
        // Roughly 2 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public HolidayCalendar(Properties properties)
    {
        this.properties = properties;
    }

    public boolean isWorkday(Date date)
    {
        switch (classifyWeekday(date))
        {
            case SATURDAY:
            case SUNDAY:
                return false;
        }

        DAY_CLASS dateDayClass = classifyHoliday(date);
        if (dateDayClass == null)
        {
            return true;
        }
        else if (!this.properties.containsKey(dateDayClass.toString()))
        {
            return false;
        }

        String validYears = properties.getProperty(dateDayClass.toString());
        if (validYears.equals("*"))
        {
            return false;
        }

        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(date);
        if (validYears.contains(String.valueOf(dateCal.get(Calendar.YEAR))))
        {
            return false;
        }

        return true;
    }
}
