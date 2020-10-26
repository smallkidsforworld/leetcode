import java.util.Arrays;

public class d410{
    public int splitArray(int[] nums, int m) {
        if(m==nums.length){
            Arrays.sort(nums);
            return nums[0];
        }
        int[][] dp = new int[nums.length+1][m+1];
        int[] sub = new int[nums.length+1];
        for(int i=0;i<=nums.length;++i)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int i=0;i<nums.length;++i)
            sub[i+1]=sub[i]+nums[i];
        dp[0][0]=0;
        for(int i=1;i<=nums.length;++i){
            for(int j=1;j<=Math.min(m,i);++j){
                for(int k=0;k<i;++k){
                    dp[i][j]=Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[nums.length][m];
    }


    public int sum(int start,int length,int[] nums){
        int result=0;
        for(int i=start;i<start+length;++i)
            result+=nums[i];
        return result;
    }
}