public class d198 {
    
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp[2]=dp[0]+nums[2];
        System.out.println(dp[2]);
        for(int i=3;i<nums.length;++i){
            dp[i]=Math.max(dp[i-1],dp[i-2]);
            System.out.println(dp[i]);
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(rob(nums));
    }

}