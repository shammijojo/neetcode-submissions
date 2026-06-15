class Solution {
    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);



        for(int i = 1; i < intervals.length; i++) {

            if(stack.isEmpty()) {
                stack.add(intervals[i]);
                continue;
            }

            int[] i1 = stack.peek();
            int[] i2 = intervals[i];

            if(i2[0]<=i1[1]) {
                // System.out.println("Popped "+stack.peek()[1]);
                stack.pop();
                stack.add(new int[]{i1[0],Math.max(i2[1],i1[1])});
                // System.out.println("Inserted "+stack.peek()[0]);
            } else {
                stack.add(i2);
                // System.out.println("Inserted "+stack.peek()[0]);
            }
        }

        int[][] result = new int[stack.size()][2];

        int size = stack.size();
        for(int i = 0; i < size; i++) {
            // System.out.println("hereh");
            // System.out.println(stack.peek()[0]+" "+stack.peek()[1]);
            result[size-i-1] = stack.pop();
        }

        return result;

    }
}
