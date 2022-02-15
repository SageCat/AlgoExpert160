public class BigOTest
{
    public static void main(String[] args)
    {
        int[] input = {1, 3, 4, 5, 6, 2, 9, 10, 11, 12, 13, 14, 15, 16, 17};

        System.out.println("=============================");
        long startTimeStamp = System.currentTimeMillis();
        int result = 1 + input[0];
        System.out.println("The value of 1 + input[0] is " + result);
        long endTimeStamp = System.currentTimeMillis();
        System.out.println("The time consumed of O(1) is " + (endTimeStamp - startTimeStamp) + "ms");

        System.out.println("=============================");
        long startTimeStamp_ = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < input.length; i++)
        {
            sum += input[i];
        }
        System.out.println("The sum of all the elements in input array is " + sum);
        long endTimeStamp_ = System.currentTimeMillis();
        System.out.println("The time consumed of sum is " + (endTimeStamp_ - startTimeStamp_) + "ms");

    }
}
