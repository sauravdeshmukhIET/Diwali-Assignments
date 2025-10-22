package MissingNumber;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4, 5};
        int missing = findMissingNumber(nums);
        System.out.println("Missing number: " + missing);
    }
}
