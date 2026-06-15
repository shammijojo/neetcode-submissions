class MinStack {

    int[] stack;
    int[] minStack;
    // int min;
    int top = -1;

    public MinStack() {
        stack = new int[30000];
        minStack = new int[30000];
        // min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        top++;
        stack[top] = val;
        if(top == 0) {
            minStack[top] = val;
        } else {
            minStack[top] = Math.min(minStack[top-1], val);
        }
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}
