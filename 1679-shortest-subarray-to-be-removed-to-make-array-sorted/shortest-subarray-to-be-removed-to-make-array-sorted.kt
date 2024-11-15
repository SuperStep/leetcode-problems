class Solution {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
            val n = arr.size
            
            // Find the first decreasing element from left
            var left = 0
            while (left + 1 < n && arr[left] <= arr[left + 1]) {
                left++
            }
            
            // If array is already sorted
            if (left == n - 1) return 0
            
            // Find the first increasing element from right
            var right = n - 1
            while (right > 0 && arr[right - 1] <= arr[right]) {
                right--
            }
            
            // Initial result is minimum of removing left part or right part
            var result = minOf(n - left - 1, right)
            
            // Try to merge left and right parts
            var i = 0
            var j = right
            while (i <= left && j < n) {
                if (arr[i] <= arr[j]) {
                    result = minOf(result, j - i - 1)
                    i++
                } else {
                    j++
                }
            }
            
            return result

    }
}