class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int a = subarrays(nums, k);
        int b = subarrays(nums, k-1);
        return a-b;
    }
    public int subarrays(int[] nums, int K) {
        int count = 0;
        int count_arr[] = new int[nums.length+1];
        for(int i=0, j=0; j<nums.length; j++) {
            if(++count_arr[nums[j]] == 1) K--;
            while(K == -1) if(--count_arr[nums[i++]] == 0) K++;
            count = count + j-i+1;
        }
        return count;
    }
}