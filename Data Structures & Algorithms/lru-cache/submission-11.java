class LRUCache {

    class DLL {
        DLL prev;
        DLL next;
        int key;
        int value;

        DLL(int key, int value) {
            this.key = key;
            this.value = value;
        }

        DLL(){}
    }

    private int capacity;
    private int size;
    private DLL head;
    private DLL tail;
    private Map<Integer,DLL> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLL();
        tail = new DLL();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        DLL node = map.get(key);
        remove(key);
        addToHead(node.key, node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLL node = map.getOrDefault(key, null);
        if(node != null) {
            remove(key);
        } else {
            node = new DLL(key, value);
        }
        addToHead(key, value);
        if(size > capacity) {
            remove(tail.prev.key);
        }
    }


    private void remove(int key) {
        DLL node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(key);
        size--;
        System.out.println("rmoved "+key);
    }

    private void addToHead(int key, int value) {
        DLL node = new DLL(key,value);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        map.put(key,node);
        size++;
    }

    private void addToTail(int key, int value) {
        DLL node = new DLL(key,value);
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
        map.put(key,node);
        size++;
    }
}
