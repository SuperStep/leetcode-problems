class Solution {
    public int jump(int[] nums) {
              int n = nums.length;
        int jumps = 0;
        int currentMax = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentMax) {
                jumps++;
                currentMax = farthest;

                if (currentMax >= n - 1) {
                    break;
                }
            }
        }

        return jumps;
  
    }
}