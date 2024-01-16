class Solution {
    public String longestCommonPrefix(String[] strs) {
if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as the reference
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Update the prefix by comparing characters of the current string with the reference prefix
            int j = 0;
            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            // Update the prefix to only include common characters
            prefix = prefix.substring(0, j);

            // If the prefix becomes an empty string, there is no common prefix
            if (prefix.isEmpty()) {
                break;
            }
        }

        return prefix;
    }
}