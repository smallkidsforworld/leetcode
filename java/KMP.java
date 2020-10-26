import java.util.Arrays;
import java.util.Collections;

public class KMP {


    public static int find(String str1,String str2){
        return str1.indexOf(str2);
    }
    
    public static int[] next(char[] nums){
        int[] result = new int[nums.length];
        int j=0;
        int k=-1;
        result[0]=-1;
        Collections.sort(Arrays.asList(1,2,3,4,5));
        while(j<nums.length-1){
            if(k==-1||nums[j]==nums[k]){
                result[++j]=++k;
            }else{
                k=result[k];
            }
        }
        return result;
    }

    // kmp improve

    public static int[] nextImprove(char[] nums){
        int[] result = new int[nums.length];
        int j=0;
        int k=-1;
        result[0]=-1;
        while(j<nums.length-1){
            if(k==-1||nums[j]==nums[k]){
                result[++j]=++k;
            }else{
                k=result[k];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for(int i:next(String.valueOf("aaab").toCharArray()))
            System.out.println(i);
        System.out.println(find("fioewjlksdujirlkbafl", "fioewjlksdujir"));
    }
}