class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
            if(hand.length%groupSize!=0) {
                return false;
            }


        Map<Integer,Integer> frequencyByElement = new HashMap<>();
        for(int val : hand) {
            int count = frequencyByElement.getOrDefault(val,0);
            frequencyByElement.put(val,count+1);
           // System.out.println("Setting "+ val +" as "+(count+1));
        }

        // for(Map.Entry<Integer,Integer> entry : frequencyByElement.entrySet()) {
        //     System.out.println(entry.getKey()+" "+entry.getValue());
        // }

        PriorityQueue<Integer> pq = new PriorityQueue<>(frequencyByElement.keySet());


        int groups = hand.length/groupSize;
        while(groups > 0) {
            int element = pq.peek();
            
            for(int i = 0; i < groupSize; i++) {
                int frequency = frequencyByElement.getOrDefault(element,0);
             //   System.out.println(element +" "+frequency);

                if(frequency == 0) return false;
                
                frequency--;  
                frequencyByElement.put(element,frequency); 

                if(frequency == 0) pq.poll();
                element++;
            }
            groups--;
        }

        return true;



    }
}
