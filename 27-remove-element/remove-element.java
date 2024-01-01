class Solution {
    public int removeElement(int[] nums, int val) {
        int overall = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != val) {
                nums[overall] = num;
                overall++;
            }
        }

        return overall;
    }
}