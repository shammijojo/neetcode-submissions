class MinStack {

    int[] stack;
    int[] minStack;
    int min;
    int top = -1;

    public MinStack() {
        stack = new int[30000];
        minStack = new int[30000];
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        top++;
        stack[top] = val;
        min = Math.min(min, val);
        minStack[top] = min;
    }
    
    public void pop() {
        if(top == 0) {
            min = Integer.MAX_VALUE;
            return;
        } 
        top--;
        min = minStack[top];
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}
