class Solution {
    public int[] getOrder(int[][] tasks) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1]==b[1]?a[2]-b[2]:a[1]-b[1]
        );

        List<int[]> tasksWithIndex = new ArrayList<>();
        for(int i= 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            tasksWithIndex.add(new int[]{task[0],task[1],i});
        }

        Collections.sort(tasksWithIndex, (a,b) -> a[0]-b[0]);

        int[] result =  new int[tasks.length];
        int k = 0;
        int currentTime = 0;
        int processed = 0;
        int i = 0;

        while(processed < tasks.length) {
            while(i < tasks.length &&
            tasksWithIndex.get(i)[0] <= currentTime) {
                pq.add(tasksWithIndex.get(i));
                i++;
            }

            if(!pq.isEmpty()) {
                int[] process = pq.poll();
                result[k++] = process[2];
                currentTime += process[1];
                processed++;
            } else {
                currentTime = tasksWithIndex.get(i)[0];
            }

        }


        // while(!pq.isEmpty()) {
        //     int[] task = pq.poll();
        //     result[k++] = task[2];
        // }

        return result;

    }
}