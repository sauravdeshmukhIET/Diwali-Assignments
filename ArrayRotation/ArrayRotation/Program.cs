using System;

class Program
{
    static void Main()
    {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        int n = nums.Length;
        k %= n;
        Reverse(nums, 0, n - 1);
        Reverse(nums, 0, k - 1);
        Reverse(nums, k, n - 1);

        Console.WriteLine(string.Join(", ", nums));
    }

    static void Reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
