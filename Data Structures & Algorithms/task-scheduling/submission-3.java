class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        Queue<int[]> queue = new LinkedList<>();

        Map<Character,Integer> map = new HashMap<>();
        for(char task : tasks) {
            map.put(task, map.getOrDefault(task,0)+1);
        }

        pq.addAll(map.values());

        int current = 0;
        while(!pq.isEmpty() || !queue.isEmpty()) {
            while(!queue.isEmpty()) {
                int[] x = queue.peek();
                if(x[1] == current) {
                    queue.poll();
                    pq.add(x[0]);
                } else {
                    break;
                }
            }

            if(!pq.isEmpty()) {
                int x = pq.poll();
                if(x > 1)
                queue.add(new int[]{x-1,current+n+1});
            }

            current++;
        }

        return current;


    }
}
