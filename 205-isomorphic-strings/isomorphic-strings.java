class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> tToSMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (sToTMapping.containsKey(charS)) {
                if (sToTMapping.get(charS) != charT) {
                    return false;
                }
            } else {
                sToTMapping.put(charS, charT);
            }

            if (tToSMapping.containsKey(charT)) {
                if (tToSMapping.get(charT) != charS) {
                    return false;
                }
            } else {
                tToSMapping.put(charT, charS);
            }
        }

        return true;
    }
}