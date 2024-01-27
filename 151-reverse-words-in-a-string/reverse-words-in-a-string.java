class Solution {
    public String reverseWords(String s) {
        var N = s.length();
        int n = 0;
        char[] chars = s.toCharArray();
        char[] answer = new char[N];
        for (int i = N - 1; i >= 0; i--) {
            if (i < 0 || chars[i] != ' ') {
                var end = i;
                while (i >= 0 && chars[i] != ' ') {
                    i--;
                }
                if (n > 0) answer[n++] = ' ';
                for (int k = i + 1; k <= end; k++) {
                    answer[n++] = chars[k];
                }
            }
        }

        return new String(answer, 0, n);
    }
}