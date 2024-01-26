class RandomizedSet {

        Random r = new Random(41);
        private List<Integer> list = new ArrayList();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if(list.contains(val))
                return false;
            return list.add(val);
        }

        public boolean remove(int val) {
            if(list.contains(val)) {
                list.remove(list.indexOf(val));
                return true;
            }
            return false;
        }

        public int getRandom() {
            return list.get(r.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */