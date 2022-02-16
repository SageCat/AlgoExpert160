import java.util.*;

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

        /*
        初始化比赛列表
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

        /*
        初始化比赛结局列表
         */
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 1, 1, 1, 0, 1, 0, 1, 1, 1));

        String winner = tournamentWinner(competition, result);
        System.out.println("the winner is " + winner);
    }

    /**
     * 第一种解法
     *
     * @param competitions
     * @param results
     * @return
     */
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results)
    {
        /*
        创建一个 HashMap 用于存储队伍的成绩
         */
        HashMap<String, Integer> gradeList = new HashMap<>();

        /*
        比赛开始前初始化所有的队伍成绩，此时成绩均为0
         */
        for (ArrayList<String> competition : competitions)
        {
            for (String s : competition)
            {
                gradeList.put(s, 0);
            }
        }

        /*
        开始比赛并记录成绩
         */
        for (int i = 0; i < competitions.size(); i++)
        {
            String winnerName;
            if (results.get(i) == 0)
            {
                /*
                右边的是赢家
                 */
                winnerName = String.valueOf(competitions.get(i).get(1));
            }
            else
            {
                /*
                左边的是赢家
                 */
                winnerName = String.valueOf(competitions.get(i).get(0));
            }
            /*
           根据赢家的列表更新成绩
             */
            gradeList.put(winnerName, gradeList.get(winnerName) + 3);
        }

        /*

         */
        return Collections.max(gradeList.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /**
     * 第二种解法
     *
     * @param competitions
     * @param results
     * @return
     */
    public static String tournamentWinnerEnhance(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results)
    {
        /*
        创建一个 HashMap 用于存储队伍的成绩
         */
        HashMap<String, Integer> gradeList = new HashMap<>();
        /*
        创建一个当前成绩最高的队伍变量，减少最后在成绩列表里寻找成绩最佳队伍的轮询操作
         */
        String currentBestTeam = "";
        gradeList.put("", 0);
        /*
        比赛开始前初始化所有的队伍成绩，此时成绩均为0
         */
        for (ArrayList<String> competition : competitions)
        {
            for (String s : competition)
            {
                gradeList.put(s, 0);
            }
        }

        /*
        开始比赛并记录成绩
         */
        for (int i = 0; i < competitions.size(); i++)
        {
            String winnerName;
            if (results.get(i) == 0)
            {
                /*
                右边的是赢家
                 */
                winnerName = String.valueOf(competitions.get(i).get(1));
            }
            else
            {
                /*
                左边的是赢家
                 */
                winnerName = String.valueOf(competitions.get(i).get(0));
            }
            /*
           根据赢家的列表更新成绩
             */
            gradeList.put(winnerName, gradeList.get(winnerName) + 3);

            if (gradeList.get(winnerName) > gradeList.get(currentBestTeam))
            {
                /*
                更新当前最佳队伍的名称
                 */
                currentBestTeam = winnerName;
            }
        }

        /*
        返回得分最高的队伍名称
         */
        return currentBestTeam;
    }
}
