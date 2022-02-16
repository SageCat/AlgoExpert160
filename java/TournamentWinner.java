import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TournamentWinner
{
    public static void main(String[] args)
    {

        /*
            [
        ["HTML", "Java"],
        ["Java", "Python"],
        ["Python", "HTML"],
        ["C#", "Python"],
        ["Java", "C#"],
        ["C#", "HTML"],
        ["SQL", "C#"],
        ["HTML", "SQL"],
        ["SQL", "Python"],
        ["SQL", "Java"]
      ]
         */

        ArrayList<ArrayList<String>> competition = new ArrayList<ArrayList<String>>();
        String[][] group = new String[][]{
                {"HTML", "Java"},
                {"Java", "Python"},
                {"Python", "HTML"},
                {"C#", "Python"},
                {"Java", "C#"},
                {"C#", "HTML"},
                {"SQL", "C#"},
                {"HTML", "SQL"},
                {"SQL", "Python"},
                {"SQL", "Java"}
        };
        for (int i = 0; i < group.length; i++)
        {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < group[i].length; j++)
            {
                temp.add(j, group[i][j]);
            }
            competition.add(i, temp);
        }

        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 1, 1, 1, 0, 1, 0, 1, 1, 0));

        tournamentWinner(competition, result);
    }

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results)
    {
        // Write your code here.

        ArrayList<ArrayList<String>> swampedCompetition = new ArrayList<ArrayList<String>>(competitions.size());

        for (int i = 0; i < competitions.size(); i++)
        {
            if (results.get(i) == 0)
            {
                swampedCompetition.add(i, competitions.get(i));
                System.out.println(swampedCompetition.get(i));
            }
            else
            {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(0, competitions.get(i).get(1));
                temp.add(1, competitions.get(i).get(0));
                swampedCompetition.add(i, temp);
            }
        }


        return "";
    }
}
