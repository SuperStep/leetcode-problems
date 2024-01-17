class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        
        return map.values().stream().distinct().count() == map.size();
    }
}