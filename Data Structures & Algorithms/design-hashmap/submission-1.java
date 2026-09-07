class MyHashMap {
    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Pair> hashmap[];

    public MyHashMap() {
        hashmap = new LinkedList[100];
        for(int i = 0 ; i < 100; i++) {
            hashmap[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int hash = key % 100;
        LinkedList<Pair> list = hashmap[hash];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                list.get(i).value = value;
                return;
            }
        }
        list.add(new Pair(key, value));
        // map.put(hash, list);
    }

    public int get(int key) {
        int hash = key % 100;

        LinkedList<Pair> list = hashmap[hash];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                System.out.println(key);
                return list.get(i).value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int hash = key % 100;

        LinkedList<Pair> list = hashmap[hash];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                list.remove(list.get(i));
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */