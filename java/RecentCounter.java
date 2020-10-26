import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> store = new LinkedList<>();
    public RecentCounter() {

    }
    
    public int ping(int t) {
        if(store.size()==0)
            store.add(t);
        else{
            while(!store.isEmpty()&&(store.peek()<t-3000||store.peek()>t))
                store.poll();
            store.add(t);
        }
        return store.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        int[] dd ={642,1849,4921,5936,5957};
        for(int d:dd)
            System.out.println(recentCounter.ping(d));
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */