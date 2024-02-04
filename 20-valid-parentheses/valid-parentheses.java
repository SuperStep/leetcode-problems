class Solution {
    public boolean isValid(String str) {
        int i = -1;
        char[] stack = new char[str.length()];

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++i] = ch;
            } else {
                if (i >= 0 &&
                    ((stack[i] == '(' && ch == ')') ||
                    (stack[i] == '[' && ch == ']') ||
                    (stack[i] == '{' && ch == '}'))) {
                    i--;
                } else {
                    return false;
                }
            }
        }
        return i == -1;
    }
}