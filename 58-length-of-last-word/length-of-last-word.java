class Solution {
    public int lengthOfLastWord(String s) {
        s = s.stripTrailing();
        return s.length() - 1 - s.lastIndexOf(" ");
    }
}