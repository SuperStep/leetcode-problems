class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
                Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> innerList = map.get(key);
            if(innerList == null)
                innerList = new ArrayList<>();
            innerList.add(str);
            map.put(key, innerList);
        }

        return new ArrayList<>(map.values());
    }
}