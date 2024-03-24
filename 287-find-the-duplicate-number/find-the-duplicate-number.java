class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Finding the intersection point of the two runners.
        do {
            slow = nums[slow]; // Move slow pointer by 1 step
            fast = nums[nums[fast]]; // Move fast pointer by 2 steps
        } while (slow != fast);

        // Phase 2: Finding the entrance to the cycle (duplicate number).
        int finder = nums[0];
        while (finder != slow) {
            slow = nums[slow]; // Move slow by 1 step
            finder = nums[finder]; // Move finder by 1 step
        }

        // Both pointers are now at the beginning of the cycle (the duplicate number).
        return finder;
    }
}