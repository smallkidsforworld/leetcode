import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class d15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
            for(int j=i+1;j<nums.length-1;j++)
                for(int k=j+1;k<nums.length;k++)
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp =Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(temp); 
                        if(!result.contains(temp))
                            result.add(temp);
                    }
        return result;
    }

    public static void main(String[] args) {
        int[] nums ={-7,-11,12,-15,14,4,4,11,-11,2,-8,5,8,14,0,3,2,3,-3,-15,-2,3,6,1,2,8,-5,-7,3,1,8,11,-3,6,3,-4,-13,-15,14,-8,2,-8,4,-13,13,11,5,0,0,9,-8,5,-2,14,-9,-15,-1,-6,-15,9,10,9,-2,-8,-8,-14,-5,-14,-14,-6,-15,-5,-7,5,-11,14,-7,2,-9,0,-4,-1,-9,9,-10,-11,1,-4,-2,2,-9,-15,-12,-4,-8,-5,-11,-6,-4,-9,-4,-3,-7,4,9,-2,-5,-13,7,2,-5,-12,-14,1,13,-9,-3,-9,2,3,8,0,3};
        for(List<Integer> t:threeSum(nums)){
            for(Integer d :t)
                System.out.print(d+" ");
            System.out.println();
        }
    }
}