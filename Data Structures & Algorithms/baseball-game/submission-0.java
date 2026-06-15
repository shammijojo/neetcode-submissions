class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < operations.length; i++) {
            String c = operations[i];
            if(c.equals("*") || c.equals("+")) {
                int x = stack.pop();
                int y = stack.peek();
                int z;
                if(c.equals("*")) {
                    z = x*y;
                } else{
                    z = x+y;
                }
                stack.push(x);
                stack.push(z);
            } else if(c.equals("D")) {
                stack.push(2*stack.peek());
            } else if(c.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

}