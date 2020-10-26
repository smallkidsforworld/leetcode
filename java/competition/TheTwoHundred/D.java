package competition.TheTwoHundred;

import java.util.HashMap;
import java.util.Map;

public class D {
    int maxSize = 1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 =new HashMap<>();
        Map<Integer,Integer> map2 =new HashMap<>();
        for(int i=0;i<nums1.length;++i)
            if(!map1.containsKey(nums1[i]))
                map1.put(nums1[i],i);
        for(int i=0;i<nums2.length;++i)
            if(!map2.containsKey(nums2[i]))
                map2.put(nums2[i],i);
        int result1 =  dfs(nums1,nums2,0,0,0,0,map1,map2);
        int result2 =  dfs(nums2,nums1,0,0,0,0,map2,map1);
        return Math.max(result1, result2);
    }
    public int dfs(int[] nums1,int[] nums2,int index_nums1,int index_nums2,int allsum,int whichpath,Map<Integer,Integer> map1,Map<Integer,Integer> map2){
        if(index_nums1>=nums1.length||index_nums2>=nums2.length)
            return allsum;
        int result1=Integer.MIN_VALUE,result2=Integer.MIN_VALUE;
        if(whichpath==0){
            result1=dfs(nums1,nums2,index_nums1+1,index_nums2,allsum+nums1[index_nums1],0,map1,map2);
            if(map2.containsKey(nums1[index_nums1])){
                Integer i = map2.get(nums1[index_nums1]);
                result2=dfs(nums1,nums2,index_nums1,i+1,allsum+nums2[i],1,map1,map2);
            }
        }else{
            result1=dfs(nums1,nums2,index_nums1,index_nums2+1,allsum+nums2[index_nums2],1,map1,map2);
            if(map1.containsKey(nums2[index_nums2])){
                Integer i = map1.get(nums2[index_nums2]);
                result2=dfs(nums1,nums2,i+1,index_nums2,allsum+nums1[i],0,map1,map2);
            }
        }
        return ((result1>result2)?result1:result2)%maxSize;
    }


    public int allMaxSum(int[] nums1,int[] nums2){
        long nums1_sum=0,nums2_sum=0,all_sum=0;
        int index_nums1=0,index_nums2=0;
        while(index_nums1<nums1.length&&index_nums2<nums2.length){
            if(nums1[index_nums1]==nums2[index_nums2]){
                all_sum+=(Math.max(nums1_sum, nums2_sum)+nums1[index_nums1]);
                index_nums1++;
                index_nums2++;
                nums1_sum=0;
                nums2_sum=0;
            }else if(nums1[index_nums1]<nums2[index_nums2]){
                    nums1_sum+=nums1[index_nums1++];
            }else if(nums1[index_nums1]>nums2[index_nums2]){
                nums2_sum+=nums2[index_nums2++];
            }
        }

        while(index_nums1<nums1.length){
            nums1_sum+=nums1[index_nums1++];
        }
        while(index_nums2<nums2.length){
            nums2_sum+=nums2[index_nums2++];
        }
        all_sum+=Math.max(nums1_sum, nums2_sum);
        return (int)(all_sum%maxSize);
    }

    public static void main(String[] args) {
        
    }
}