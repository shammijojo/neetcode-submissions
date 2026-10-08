class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        //dq.addLast(0);

        for(int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            if(!dq.isEmpty() && dq.peekFirst() < i-k+1) {
                dq.pollFirst();
            }

            dq.addLast(i);

            if(i < k-1) continue;
            result[i-k+1] = nums[dq.peekFirst()];
        }

        return result;
    }
}
