class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        int lastIndexOfSpace = s.lastIndexOf(' ');
        return s.length() - lastIndexOfSpace - 1;
    }
}