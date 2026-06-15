class Solution {
    private class Task {
        int executeTime;
        int count;

        Task(int count,int executeTime) {
            this.count = count;
            this.executeTime = executeTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> frequencyByTask = new HashMap<>();

        for(char task : tasks) {
            frequencyByTask.put(task,frequencyByTask.getOrDefault(task,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(frequencyByTask.values());
        Queue<Task> queue = new LinkedList<>();

        int cycle = 0;
        while(!pq.isEmpty() || !queue.isEmpty()) {
            while(!queue.isEmpty() && queue.peek().executeTime == cycle) {
            pq.add(queue.poll().count);
            }

            cycle++;

            if(!pq.isEmpty()) {
                int x = pq.poll();
                //System.out.println(x);
                if(x > 1)
                queue.add(new Task(x-1,n+cycle));
            }

            
            
        }

        return cycle;



    }
}
