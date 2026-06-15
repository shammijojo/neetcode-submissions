class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.add(asteroids[0]);
       // stack.add(asteroids[1]);

        for(int i = 1; i < asteroids.length; i++) {
            stack.add(asteroids[i]);

            while(stack.size() > 1) {
                int first = stack.pop();
                int second = stack.pop();

                if(second > 0 && first < 0) {
                    if(Math.abs(first) == Math.abs(second)) {
                        continue;
                    }
                    int bigger = Math.abs(first)>Math.abs(second)?first:second;
                    stack.add(bigger);
                } else {
                    stack.add(second);
                    stack.add(first);
                    break;
                }
            }
        }

        int[] result = new int[stack.size()];
            int index = stack.size()-1;
            while(!stack.isEmpty()) {
                result[index--] = stack.pop();
            }

        return result;
    }
}