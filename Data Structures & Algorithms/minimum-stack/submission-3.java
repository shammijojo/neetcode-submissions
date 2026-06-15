class MinStack {

    private int[] stack;
    private int[] minStack;
    private int min = Integer.MAX_VALUE;
    private int top = -1;

    public MinStack() {
        stack = new int[30000];
        minStack = new int[30000];
    }
    
    public void push(int val) {

        if(top==-1) {
            min = val;
        } else {
            min = Math.min(min,val);
        }        
        top++;
        stack[top] = val;
        minStack[top] = min;
    }
    
    public void pop() {
        top--;
        if(top<0) {
            min = Integer.MIN_VALUE;
        } else {
            min = minStack[top];
        }
        
        
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}
