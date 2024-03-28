class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int left = 0, right = 0, maxLen = 0, count = 0;

        while (right < nums.length) {
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);
            if (frequencyMap.get(nums[right]) > k) {
                count++;
            }
            right++;

            while (count > 0) {
                frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);
                if (frequencyMap.get(nums[left]) >= k) {
                    count--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;  
    }
}