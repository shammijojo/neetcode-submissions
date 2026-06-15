class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") || token.equals("*")
            || token.equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(calculate(x,y,token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private int calculate(int x, int y, String operator) {
        switch(operator) {
            case "+": 
              return x+y;
            case "-": 
              return x-y;  
            case "*": 
              return x*y;  
            case "/": 
              return x/y;  
        }
        return 0;
    }
}
