class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Integer, Integer> needLetters = new HashMap<>();

        ransomNote.chars().forEach(c -> needLetters.merge(c, 1, Integer::sum));
        magazine.chars().forEach( c -> needLetters.merge(c, -1, Integer::sum));

        return needLetters.values().stream().allMatch(e -> e <= 0);
    }
}