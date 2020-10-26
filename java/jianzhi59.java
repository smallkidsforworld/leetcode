import java.util.Arrays;
import java.util.TreeSet;

public class jianzhi59{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] array_list = new int[k];
        System.arraycopy(nums, 0, array_list, 0, k);
        Arrays.sort(array_list);
        return null;
    }

    public static void main(String[] args) {
        int a = 1,b=2;
        int dd = a>b?a:b+3;
        System.out.println(dd);        
    }


}