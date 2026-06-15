class KthLargest {

    int[] stream;
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        stream = nums;
        this.k = k;
        pq = new PriorityQueue<>();

        for(int x : nums) {
            pq.add(x);
        }

        while(pq.size() > k) {
            pq.poll();
        }


    }
    
    public int add(int val) {
        pq.add(val);
        
        while(pq.size() > k) pq.poll();


        return pq.peek();        
    }
}
