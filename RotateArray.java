import java.util.Arrays;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;

        if (n == 0) {
            return nums;
        }

        k = k % n;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(rotateArray(nums, k)));
    }
}
