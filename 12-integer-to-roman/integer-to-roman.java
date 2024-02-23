class Solution {
    public String intToRoman(int num) {
        // Create a TreeMap to store Roman numeral symbols and their values
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder result = new StringBuilder();
        
        // Iterate through the symbols in descending order
        for (int value : map.descendingKeySet()) {
            // While the given integer is greater than or equal to the value of the current symbol
            while (num >= value) {
                // Subtract the value of the symbol from the integer and append the symbol to the result
                num -= value;
                result.append(map.get(value));
            }
        }
        
        return result.toString();
    }
}