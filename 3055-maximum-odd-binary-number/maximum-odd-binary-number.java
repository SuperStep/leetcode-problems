class Solution {
    public String maximumOddBinaryNumber(String s) {
        // Count the number of '1's in the string
        int countOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOnes++;
            }
        }

        // Create a new StringBuilder with the same length as s
        StringBuilder result = new StringBuilder(s.length());

        // Append '1's to the result (leave the last '1' for the end to make it odd)
        for (int i = 0; i < countOnes - 1; i++) {
            result.append('1');
        }

        // Append '0's to the result
        for (int i = countOnes - 1; i < s.length() - 1; i++) {
            result.append('0');
        }

        // Append the last '1' to make the number odd
        result.append('1');

        return result.toString();
    }

}