class LRUCache {

    int capacity;
    int size;
    Map<Integer,DLL> map;
    DLL head;
    DLL tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key) && map.get(key)!=null) {
            moveToEnd(key);
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key) && map.get(key)!=null) {
            map.get(key).value = value;
            moveToEnd(key);
        } else {
            insert(new DLL(key,value));
        }
    }

    private void insert(DLL dll) {
        if(size == capacity) {
            deleteFromHead();
        }
        size++;
        if(head == null) {
            head = dll;
            tail = dll;
        } else {
            tail.next = dll;
            dll.previous = tail;
            tail = dll;
        }
        map.put(dll.key,dll);
    }

    private void deleteFromHead() {
        map.put(head.key,null);
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        DLL newHead = head.next;
        head.next = null;
        newHead.previous = null;
        head = newHead;
        size--;
    }

    private void deleteFromBetween(DLL node) {
        DLL before = node.previous;
        DLL after = node.next;
        before.next = after;
        after.previous = before;
        node.previous = null;
        node.next = null;
        map.put(node.key,null);
        size--;

    }

    private void moveToEnd(int key) {
        DLL node = map.get(key);
        if(tail == node){
            return;
        } else if(head == node) {
            deleteFromHead();
            insert(node);
        } else {
            deleteFromBetween(node);
            insert(node);
        }
    }

    class DLL {
        int key;
        int value;
        DLL next;
        DLL previous;

        public DLL(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
