
class Solution {
    public boolean wordPattern(String pattern, String s) {
               
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");

        if(words.length == pattern.length() && pattern.length() == 1)
            return true;
        if(words.length != pattern.length())
            return false;

        for(int i = 0; i < words.length; i++) {
            Character c = pattern.charAt(i);
            String word = words[i];

            if(map.containsKey(c) || map.containsValue(word)) {
                if(map.get(c) == null)
                    return false;
                if(map.get(c).equals(word))
                    continue;
                else
                    return false;
            }
            else {
                map.put(c, word);
            }
        }
        return true;
    }
}