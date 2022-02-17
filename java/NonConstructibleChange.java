import java.util.Arrays;
import java.util.HashSet;

public class NonConstructibleChange
{
    public static void main(String[] args)
    {

        int[] input = {5, 7, 1, 1, 2, 3, 22};
        int i = nonConstructibleChange(input);

    }

    /**
     * 第一版，对于可能为 [],[1],[4]这种情况的考虑不到位，所以额外增加了很多代码对这些情况进行特殊处理
     * <p>
     * 时间复杂度： O(nlog(n)) 【排序】
     * 空间复杂度： O(1)
     *
     * @param coins
     * @return
     */
    public static int nonConstructibleChange(int[] coins)
    {

        Arrays.sort(coins);

        /*
        特殊情况的处理
         */
        if (coins.length == 0)
        {
            return 1;
        }
        else if (coins.length == 1 && coins[0] == 1)
        {
            return 2;
        }
        else if (coins.length == 1 && coins[0] > 1)
        {
            return 1;
        }

        int currentBiggestSum = coins[0];
        for (int j = 1; j < coins.length; j++)
        {
            if (coins[j] > currentBiggestSum + 1)
                return currentBiggestSum + 1;
            currentBiggestSum += coins[j];
        }
        return currentBiggestSum + 1;
    }


    /**
     * 第二版，使用增强的 for 循环
     * - 避免了可能为 [] 情况下的 角标越界异常
     * - 将 currentBiggestSum 的初始值设置为 0，避免了特殊情况下，返回值不准确的问题
     * <p>
     * 时间复杂度： O(nlog(n)) 【排序】
     * 空间复杂度： O(1)
     *
     * @param coins
     * @return
     */
    public static int nonConstructibleChangeEnhance(int[] coins)
    {

        Arrays.sort(coins);

        int currentBiggestSum = 0;

        for (int coin : coins)
        {
            if (coin > currentBiggestSum + 1)
            {
                return currentBiggestSum + 1;
            }
            currentBiggestSum += coin;
        }

        return currentBiggestSum + 1;
    }
}
