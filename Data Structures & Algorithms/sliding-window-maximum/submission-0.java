class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] max = new int[n-k+1];
        int index = 0;


        for(int i = 0; i < n; i++) {
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(nums[i]);

            if(i < k-1) continue;

            max[index++] = dq.peekFirst();
            if(dq.peekFirst() == nums[i-k+1]) {
                dq.pollFirst();
            }
        }

        return max;
    }
}
