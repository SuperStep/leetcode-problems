class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer exists = map.put(nums[i], i);
                if(exists != null) {
                    if(Math.abs(exists - i) <= k) {
                        return true;
                    }
                }
            }

            return false;
        }
}