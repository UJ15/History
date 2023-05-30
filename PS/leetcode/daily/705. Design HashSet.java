//my solution

class MyHashSet {

    private static int MAX_SET_SIZE = 1000001;
    private int[] set;

    public MyHashSet() {
        set = new int[MAX_SET_SIZE];
        Arrays.fill(set, -1);
    }

    public void add(int key) {
        set[key] = key;
    }

    public void remove(int key) {
        set[key] = -1;
    }

    public boolean contains(int key) {
        return set[key] == key;
    }
}

// use hash

class MyHashSet {
    private static final int HASH_VALUE = 1000;
    private List<List<Integer>> set;

    public MyHashSet() {
        set = new ArrayList<>();
        for (int i = 0 ; i < HASH_VALUE ; i++) {
            set.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        int index = hash(key);
        List<Integer> buket = set.get(index);
        if (!buket.contains(key)) {
            buket.add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        List<Integer> buket = set.get(index);
        buket.remove(Integer.valueOf(key));

    }

    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> buket = set.get(index);
        return buket.contains(key);
    }

    private int hash(int key) {
        return key % HASH_VALUE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */