import java.util.Arrays;

public class RotateArray {

    // Method to rotate array to the right by n steps
    public static void rotateArray(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty!");
            return;
        }

        n = n % arr.length; // handle cases where n > length
        if (n == 0) {
            System.out.println("No rotation needed.");
            return;
        }

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Rotate to the right by n positions
        for (int count = 1; count <= n; count++) {
            int temp = arr[arr.length - 1]; // store last element
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1]; // shift right
            }
            arr[0] = temp; // move last element to first
            System.out.println("After rotation " + count + ": " + Arrays.toString(arr));
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(nums, 3);
    }
}
