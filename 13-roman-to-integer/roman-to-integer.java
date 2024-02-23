class Solution {
    public int romanToInt(String s) {
        // Create a HashMap to store the values of each Roman numeral
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int length = s.length();
        
        // Iterate through the Roman numeral string from left to right
        for (int i = 0; i < length; i++) {
            int currentValue = map.get(s.charAt(i));
            // If the value of the numeral is less than the value of the next numeral, subtract it
            if (i < length - 1 && currentValue < map.get(s.charAt(i + 1))) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
        }
        
        return total;
    }
}