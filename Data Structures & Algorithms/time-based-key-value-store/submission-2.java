class TimeMap {

    class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        if(map.containsKey(key)) {
            map.get(key).add(pair);
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(pair);
            map.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = map.get(key);
        if(pairs == null) return "";
        int left = 0;
        int right = pairs.size()-1;
        int index = -1;

        while(left<=right) {
            int mid = (left+right)/2;
            if(timestamp > pairs.get(mid).timestamp) {
                index = mid;
                left = mid+1;
            } else if(timestamp < pairs.get(mid).timestamp){
                right = mid-1;
            } else {
                return pairs.get(mid).value;
            }
        }

        return index == -1 ? "": pairs.get(index).value; 
    }
}
