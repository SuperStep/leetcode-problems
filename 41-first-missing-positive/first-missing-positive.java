class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // First, separate positive and negative numbers.
        int shift = segregate(nums, n);

        // Use the array index as a hash to store the frequency of positive numbers.
        int[] positiveNums = new int[n - shift];
        for (int i = shift; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n - shift) {
                positiveNums[num - 1] = nums[i] > 0 ? -nums[i] : nums[i];
            }
        }

        // Find the first index which has a positive value.
        for (int i = 0; i < positiveNums.length; ++i) {
            if (positiveNums[i] >= 0) {
                return i + 1;
            }
        }

        // If all indices are marked, return the next number.
        return positiveNums.length + 1;
    }

     // Function to segregate positive and negative numbers.
    private int segregate(int[] nums, int size) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] <= 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return j;
    }
}