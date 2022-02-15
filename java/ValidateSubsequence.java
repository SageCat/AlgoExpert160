import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ValidateSubsequence
{
    public static void main(String[] args)
    {
        int[] master = {};
        int[] sub = {};

        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
//        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        ArrayList<Integer> sec = new ArrayList<>(Arrays.asList(1, 6, -1, 10));
//        ArrayList<Integer> sec = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10, 10));
        boolean result = isValidSubsequence(array, sec);
        System.out.println(result);

    }

    /**
     * 时间复杂度 O(n) + O(1)
     * 空间复杂度 O(1)
     *
     * @param array    主列表
     * @param sequence 子列表
     * @return sequence 是否是 array 的子列表
     */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence)
    {
        /*
          若子列表的长度大于主列表的长度，则不用再比较了
         */
        if (array.size() < sequence.size())
        {
            return false;
        }

        int j = 0;
        for (Integer integer : array)
        {
            /*
            第一个条件：防止角标越界
            第二个条件：比较数值
             */
            if (j < sequence.size() && Objects.equals(integer, sequence.get(j)))
            {
                j++;
            }
        }
        return j == sequence.size();
    }
}
