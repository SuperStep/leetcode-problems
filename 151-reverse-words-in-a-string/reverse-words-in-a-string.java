class Solution {
    public String reverseWords(String s) {
         return String.join(" ", invertUsingFor(s.split("\\s+"))).trim();
    }
    static String[] invertUsingFor(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i].trim();
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}