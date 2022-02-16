import java.util.Arrays;

public class SortedSquaredArray
{
    public static void main(String[] args)
    {
        int[] input = {-10, -5, 2, 5, 10, 20};
        int[] result = sortedSquaredArrayEnhance(input);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 第一版
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)
     *
     * @param array 输入数组
     * @return 返回结果
     */
    public static int[] sortedSquaredArray(int[] array)
    {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int resultPointer = array.length - 1;
        int[] result = new int[array.length];

        while (leftIndex <= rightIndex)
        {
            if ((leftIndex != rightIndex) && (Math.abs(array[leftIndex]) <= Math.abs(array[rightIndex])))
            {
                result[resultPointer] = array[rightIndex] * array[rightIndex];
                rightIndex--;
                resultPointer--;
            }
            else if ((leftIndex != rightIndex) && (Math.abs(array[leftIndex]) > Math.abs(array[rightIndex])))
            {
                result[resultPointer] = array[leftIndex] * array[leftIndex];
                leftIndex++;
                resultPointer--;
            }
            else
            {
                result[resultPointer] = array[rightIndex] * array[rightIndex];
                leftIndex++;
                rightIndex--;
            }
        }
        return result;
    }

    /**
     * 第二版
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)
     *
     * @param array 输入数组
     * @return 返回结果
     */
    public static int[] sortedSquaredArrayEnhance(int[] array)
    {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int[] result = new int[array.length];

        /*
        使用变量从结果数组的最大角标处开始存储数据，相比第一版，省去了一个标注角标的变量
         */
        for (int i = array.length - 1; i >= 0; i--)
        {
            int smallerValue = array[leftIndex];
            int largerValue = array[rightIndex];

            if (Math.abs(smallerValue) < Math.abs(largerValue))
            {
                result[i] = largerValue * largerValue;
                rightIndex--;
            }
            else
            {
                result[i] = smallerValue * smallerValue;
                leftIndex++;
            }
        }
        return result;
    }
}
