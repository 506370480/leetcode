package other;


public class MinStack {
    private int[] arrays;
    private int top;
    private int[] min;
    public MinStack() {
        arrays = new int[30000];
        min = new int[30000];
        top = -1;
    }

    public void push(int val) {
        arrays[++top]=val;
        if(top==0){
            min[top]=val;
        }else{
            min[top] = val<min[top-1]?val:min[top-1];
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return arrays[top];
    }

    public int getMin() {
        return min[top];
    }
}
