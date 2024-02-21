class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1){
            return 1;
        }
        Arrays.sort(nums);

        int prev = nums[0];
        int maxChain = 1;
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if(prev - nums[i] == -1) {
                counter +=1;
                if (counter > maxChain)
                    maxChain = counter;
            } else if(prev == nums[i]) {
                continue;
            } else {
                counter = 1;
            }
            prev = nums[i];
        }

        return maxChain;
    }
}