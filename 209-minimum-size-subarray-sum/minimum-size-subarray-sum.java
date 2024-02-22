class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int a = 0;
        while (a < nums.length) {
            sum += nums[a];
            a++;
            if (sum >= target) {
                break;
            }
        }
        if (sum < target) {
            return 0;
        }
        int b = 1;
        while (a + b - 1 < nums.length) {
            sum -= nums[b - 1];
            sum += nums[a + b - 1];
            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[a + b - 1];
                    if (sum >= target) {
                        a--;
                    }
                }
                sum += nums[a + b - 1];
            }
            b++;
        }
        while (sum >= target) {
            sum -= nums[nums.length - a];
            if (sum >= target) {
                a--;
            }
        }
        return a;
    }
}