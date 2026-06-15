class LRUCache {

    private class Dll {
        int key;
        int value;
        Dll next;
        Dll prev;

        Dll(){}

        Dll(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    int size;
    Map<Integer,Dll> map;
    Dll head;
    Dll tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Dll();
        tail = new Dll();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Dll node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Dll node = map.get(key);
            node.value = value;
            remove(node);
            insert(node);
            return;
        }

        Dll node = new Dll(key,value);
        insert(node);

        if(size > capacity) {
            remove(head.next);
        }
    }

    private Dll remove(Dll top) {
         Dll before = top.prev;
         Dll after = top.next;
         before.next = after;
         after.prev = before;
         top.next = null;
         top.prev = null;
         size--;
         map.remove(top.key);
         return top;
    }

    private void insert(Dll node) {
        Dll last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
        size++;
        map.put(node.key,node);
    }

}
