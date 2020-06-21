import java.util.LinkedList;

class MinStack {
    private int minnum=Integer.MAX_VALUE;
    LinkedList<Integer> store;
    /** initialize your data structure here. */
    public MinStack() {
        store=new LinkedList<>();
    }   
    
    public void push(int x) {
        if(x<minnum)
            minnum=x;
        store.add(x);
    }
    
    public void pop() {
        store.removeLast();
        minnum=Integer.MAX_VALUE;
        for(Integer s:store){
            if(s<minnum)
                minnum=s;
        }
    }
    
    public int top() {
        return store.getLast();
    }
    
    public int getMin() {
        return minnum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */