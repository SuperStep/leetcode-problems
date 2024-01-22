class Solution {
    public int[] findErrorNums(int[] nums) {
                   int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result[0] = Math.abs(nums[i]); // Duplicate number
            } else {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1; // Missing number
                break;
            }
        }

        return result;

    }
}