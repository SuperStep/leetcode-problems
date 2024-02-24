class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int row = 0, direction = 1;
        for (char c : s.toCharArray()) {
            rows.get(row).append(c);
            if (row == 0) {
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }
            row += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder rowString : rows) {
            result.append(rowString);
        }
        return result.toString();
    }
}