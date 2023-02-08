class MyHashMap {
    private static final int MOD = 100000;
    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[100000];
    }

    public void put(int key, int value) {
        int mod = key % MOD;
        ListNode temp = map[mod];

        if (map[mod] == null) {
            map[mod] = new ListNode(key, value);
        } else {
            while (temp.key != key && temp.next != null) {
                temp = temp.next;
            }

            if (temp.key == key) {
                temp.val = value;
                return;
            }

            temp.next = new ListNode(key, value);
        }
    }

    public int get(int key) {
        int mod = key % MOD;
        ListNode temp = map[mod];

        if (temp == null) {
            return -1;
        } else {
            while (temp != null && temp.key != key) {
                temp = temp.next;
            }

            if (temp == null) {
                return -1;
            }

            return temp.val;
        }
    }

    public void remove(int key) {
        int mod = key % MOD;
        ListNode temp = map[mod];

        if (temp == null) {
            return;
        }

        if (temp.key == key) {
            map[mod] = null;
            return;
        }

        while (temp.next != null && temp.next.key != key) {
            temp = temp.next;
        }

        if (temp.next != null && temp.next.key == key) {
            temp.next = temp.next.next;
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;

    public ListNode() {};
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */