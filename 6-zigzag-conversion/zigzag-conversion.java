class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        int gap = 2*numRows - 2;
        int i, j, k, l;
        for (i=0,j=0; i<numRows; i++) {
            if (i > 0 && i < numRows-1) {
                for (k=i,l=gap-i; l<chars.length; k+=gap,l+=gap) {
                    result[j++] = chars[k];
                    result[j++] = chars[l];
                }
                if (k < chars.length) {
                    result[j++] = chars[k];
                }
            } else {
                for (k=i; k<chars.length; k+=gap) {
                    result[j++] = chars[k];
                }
            }
        }
        return new String(result);
    }
}