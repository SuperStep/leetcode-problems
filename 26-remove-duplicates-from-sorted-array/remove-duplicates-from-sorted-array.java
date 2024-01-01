class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueCount = 1; 
        int currentPointer = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[currentPointer] = nums[i];
                currentPointer++;
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}