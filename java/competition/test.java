import java.util.HashMap;
import java.util.Map;

// package competition;

public class test {
    // HashMap
    
    public static boolean binarySearch(int target,int[] num){
        int left = 0,right=num.length,mid;
        while(left<=right){
            mid = (right-left)/2+left;
            if(num[mid]>target)
                right=mid-1;
            else if(num[mid]<target)
                left = mid+1;
            else 
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] d = new int[1][];
        System.out.println(d.length);
    }
}