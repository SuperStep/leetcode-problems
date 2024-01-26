class RandomizedSet {
    Random rand  = new Random();
    private Map<Integer , Integer> map ;
    private ArrayList<Integer> list ;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean search (int val){
        return map.containsKey(val);
    }

    public boolean insert(int val) {
        if(search(val)) return false;

        list.add(val);
        map.put(val , list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!search(val)) return false;

        int index = map.get(val);
        list.set(index , list.get(list.size() - 1));
        map.put(list.get(index) , index);
        list.remove(list.size() - 1);
        map.remove(val);
         return true;
    }
    
    public int getRandom() {
        int max = list.size();
        int randChoice = rand.nextInt(max);
        return list.get(randChoice);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */