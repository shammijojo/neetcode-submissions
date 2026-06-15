class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
          if(!(tokens[i].equals("/") || tokens[i].equals("*") || tokens[i].equals("+")
          || tokens[i].equals("-"))) {
            stack.push(tokens[i]);
            continue;
          }

          
          String a = stack.pop();
          String b = stack.pop();

          stack.push(calculate(tokens[i],Integer.parseInt(b),Integer.parseInt(a)));
        }

        return Integer.parseInt(stack.pop());
    }

    private String calculate(String token, int a, int b) {
      switch(token) {
        case "/":
          return String.valueOf(a/b);
        case "*":
          return String.valueOf(a*b);
        case "+":
          return String.valueOf(a+b);
        case "-":
          return String.valueOf(a-b);        
      }
      return "0";
    }
}
