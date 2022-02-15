import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TowNumSum
{
    public static void main(String[] args)
    {

        int[] array = {1, 2, 3, -2, -1, 9, 4, 7, 10, 13, -7};
        int[] result = twoNumberSumSort(array, 17);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 时间复杂度：O(n^2) = O(n*n)
     * 空间复杂度：O(1)
     *
     * @param array     输入的数组
     * @param targetSum 目标值
     * @return 能匹配到目标值的组合
     */
    public static int[] twoNumberSum(int[] array, int targetSum)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            int firstValue = array[i];
            for (int j = i + 1; j < array.length; j++)
            {
                int secondValue = array[j];
                if ((firstValue + secondValue) == targetSum)
                {
                    return new int[]{firstValue, secondValue};
                }
            }
        }
        return new int[0];
    }

    /**
     * 时间复杂度：O(n) + O(1)
     * 空间复杂度：O(n) + O(1)
     *
     * @param array     输入的数组
     * @param targetSum 目标值
     * @return 能匹配到目标值的组合
     */

    public static int[] twoNumberSumEnhance(int[] array, int targetSum)
    {
        Set<Integer> sums = new HashSet<>();

        for (int j : array)
        {
            int targetMatch = targetSum - j;
            if (sums.contains(targetMatch))
            {
                return new int[]{j, targetMatch};
            }
            else sums.add(j);
        }
        return new int[0];
    }


    /**
     * 时间复杂度：O(n*log(n)) = O(n*log(n)) + O(n) + O(1)
     * 空间复杂度：O(n) + O(1)
     *
     * @param array     输入的数组
     * @param targetSum 目标值
     * @return 能匹配到目标值的组合
     */

    public static int[] twoNumberSumSort(int[] array, int targetSum)
    {
        Arrays.sort(array);

        for (int left = 0, right = array.length - 1; left < right; )
        {
            if (array[left] + array[right] < targetSum)
            {
                left++;
            }
            else if (array[left] + array[right] > targetSum)
            {
                right++;
            }
            else return new int[]{array[left], array[right]};
        }
        return new int[0];
    }


    /**
     * 时间复杂度：O(n*log(n)) = O(n*log(n)) + O(n) + O(1)
     * 空间复杂度：O(n) + O(1)
     *
     * @param array     输入的数组
     * @param targetSum 目标值
     * @return 能匹配到目标值的组合
     */

    public static int[] twoNumberSumSort(int[] array, int targetSum)
    {
        Arrays.sort(array);

        for (int left = 0, right = array.length - 1; left < right; )
        {
            if (array[left] + array[right] < targetSum)
            {
                left++;
            }
            else if (array[left] + array[right] > targetSum)
            {
                right++;
            }
            else return new int[]{array[left], array[right]};
        }
        return new int[0];
    }
}
