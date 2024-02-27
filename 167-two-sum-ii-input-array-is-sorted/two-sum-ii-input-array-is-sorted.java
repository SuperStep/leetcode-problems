class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int n = numbers.length;
        int left = 0, right = n-1, mid;
        while(left < right) {
            mid = (left+right)/2;
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                answer[0] = left+1;
                answer[1] = right+1;
                return answer;
            } 
            else if(sum < target) {
                if(numbers[right] + numbers[mid] < target) {
                    left = mid+1;
                }
                else left++;
            }
            else {
                if(numbers[left] + numbers[mid] > target) {
                    right = mid-1;
                }
                else right--;
            }
        }

        return answer;
    }
}