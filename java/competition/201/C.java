import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class C {
    public int maxNonOverlapping(int[] nums, int target) {
        return 0;
    }

    public static void main(String[] args) {
        int res = 0, result = 0;
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Integer> future_one = executor.submit(new ActivityA());
        Future<Integer> future_two = executor.submit(new ActivityA());
        try {
            res = future_one.get();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            result = future_two.get();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("hello the thread has passed the result is "+res);
        System.out.println("**************************  ");
        System.out.println("hello the thread has passed the result is "+result);
    }
}


class ActivityA implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        int res = 0;
        for(int i=0;i<100;i++){
            System.out.print(i+" ");
            res+=i;
            if(res%10==0)
                System.out.println();
        }
        return res;
    }
    
}