import java.util.HashSet;
import java.util.Set;

public class d213{
    // StringBuilder
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        else if(nums.length==1)
            return nums[0];
        else if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        else if(nums.length==3)
            return nums[1];

        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }

    public int rob(int[] nums,int start,int end) {
        int[] dp = new int[nums.length+1];
        dp[0]=nums[start];
        dp[1]=nums[start+1];
        dp[2]=dp[start]+nums[start+2];
        for(int i=start+3;i<end;++i){
            dp[i]=Math.max(dp[i-2],dp[i-3])+nums[i];
        }
        return Math.max(dp[end-1],dp[end-2]);
    }
    // {2,1,1,2}
}