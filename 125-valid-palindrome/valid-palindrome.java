class Solution {
        static List<Character> alphabetList = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '5', '6', '7', '8', '9'
    );
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;
       List<Character> chars = new ArrayList<>();

       for (char c : s.toLowerCase().toCharArray()) {
           if(alphabetList.contains(c))
               chars.add(c);
       }
        if (chars.size() <= 1)
            return true;
       return isPalindromeRec(chars);
    }

    private static boolean isPalindromeRec(List<Character> chars ) {

        if (chars.size() <= 1)
            return true;
        char first = chars.get(0);
        char last = chars.get(chars.size() - 1);

        if(chars.size() == 2 && first == last)
            return true;

        if (first == last)
            return isPalindromeRec(chars.subList(1, chars.size() - 1));
        else
            return false;
    }
}