class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);

        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (charIndex[c] >= left) {
                left = charIndex[c] + 1;
            }
            charIndex[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}