class Solution {
    public int removeDuplicates(int[] nums) {
        int overall = 0;
        int dups = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[overall] == nums[i]) {
                dups++;
                if (dups == 2) {
                    overall++;
                    nums[overall] = nums[i];
                }
            } else {
                dups = 1;
                overall++;
                nums[overall] = nums[i];
            }
        }
        return overall + 1;
    }
}