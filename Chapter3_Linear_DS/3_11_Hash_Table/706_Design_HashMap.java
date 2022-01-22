//생성자 사용을 이상하게 해서 좀 오래걸렸다. 
class MyHashMap {
    class ListNode{
        int key;
        int value;
        ListNode next;
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
            ListNode next = null;
        }
    }
    ListNode[] map = new ListNode[1000];
    public MyHashMap() {
        for (int i = 0 ; i < 1000 ; i++){
            map[i] = null;
        }
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        if (map[index] == null){
            map[index] = new ListNode(key, value);
            return ;
        }
        ListNode cur = map[index];
        while (cur != null){
            if (cur.key == key){
                cur.value = value;
                return ;
            }
            if (cur.next == null){
                break;
            }
            cur = cur.next;
        }
        cur.next = new ListNode(key, value);
    }
    
    public int get(int key) {
        int index = getHash(key);
        ListNode cur = map[index];
        while (cur != null){
            if (cur.key == key)
                return cur.value;
            cur = cur.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if (map[index] != null && map[index].key == key){
            map[index] = map[index].next;
            return ;
        }
        ListNode pre = map[index];
        ListNode cur = map[index];
        while (cur != null){
            if (cur.key == key){
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
    }
    
    public int getHash(int key){
        return key % 1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
