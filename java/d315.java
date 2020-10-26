import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class d315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums.length==0)
            return result;
        if(nums.length==1){
            result.add(0);
            return result;
        }
        for(int i=0;i<nums.length-1;++i){
            result.add(rightSmall(nums,i));
        }
        result.add(0);
        return result;
    }

    int rightSmall(int[] nums,int start){
        int result = 0;
        int[] dd = nums.clone();
        Arrays.sort(dd);
        for(int i =start+1;i<nums.length;++i){
            if(nums[i]<nums[start])
                result++;
        }
        return result;
    }
}