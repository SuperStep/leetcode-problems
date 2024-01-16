class Solution {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        int counter = s.length();
        for(byte c : s.getBytes()){
            int last = t.indexOf(c, start);
            if(last < 0)
                return false;
            start = last + 1;
            counter--;
            System.out.print(counter);
        }
        return counter == 0;
    }
}