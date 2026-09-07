class MyHashMap {
    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, LinkedList<Pair>> map;

    public MyHashMap() {
        map = new HashMap<>();
    }

    public void put(int key, int value) {
        int hash = Objects.hash(key);
        LinkedList<Pair> list = map.getOrDefault(hash, new LinkedList<Pair>());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                list.get(i).value = value;
                return;
            }
        }
        list.add(new Pair(key, value));
        map.put(hash, list);
    }

    public int get(int key) {
        int hash = Objects.hash(key);
        if (map.containsKey(hash)) {
            LinkedList<Pair> list = map.getOrDefault(hash, new LinkedList<Pair>());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    System.out.println(key);
                    return list.get(i).value;
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = Objects.hash(key);
        if (map.containsKey(hash)) {
            LinkedList<Pair> list = map.getOrDefault(hash, new LinkedList<>());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    list.remove(list.get(i));
                }
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