/**
 * Created by Classdumper, User Peter Heusch
 * Creation Date: 21.10.2017 10:05:26
 */
package division;

import de.hft_stuttgart.unittest.loader.Skeleton;
import divisionData.Game;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Skeleton
public class MatchDay
{

    static
    {
        System.err.println("Please call injectClass(\"division.MatchDay\"), you've imported a skeleton");
    }

    public static final String DATE_FORMAT_STRING = "dd-MM-yyyy";
    public static final SimpleDateFormat DF = null;
    private final int dayCount;
    private Date date;
    private final int teamCount;
    private final List<Game> games;

    public MatchDay(int date, Date teamCount, int arg04)
    {
        // Roughly 4 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static void main(String[] args) throws ParseException
    {
        // Roughly 6 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String toString()
    {
        // Roughly 9 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Date getDate()
    {
        // Roughly 1 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setDate(Date date)
    {
        // Roughly 1 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int getDayCount()
    {
        // Roughly 1 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int getTeamCount()
    {
        // Roughly 1 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void addGame(Game game)
    {
        // Roughly 4 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Game[] getGames()
    {
        // Roughly 1 lines of implementation
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
