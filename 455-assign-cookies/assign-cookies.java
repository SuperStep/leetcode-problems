class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;
        int cookieIndex = 0;

        for (int greedFactor : g) {
            while (cookieIndex < s.length && s[cookieIndex] < greedFactor) {
                cookieIndex++;
            }

            if (cookieIndex < s.length) {
                contentChildren++;
                cookieIndex++;
            }
        }

        return contentChildren;
    }
}