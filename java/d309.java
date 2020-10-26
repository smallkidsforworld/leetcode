public class d309{
    public int maxProfit(int[] prices){
        if(prices.length<=1)
            return 0;
        int[][] dp = new int[prices.length][3];
        // dp[i][0] have stock the biggest interest
        // dp[i][1] no stock but frzzing the biggest interest
        // dp[i][2] no stock no frzzing the biggest interest
        dp[0][0]=prices[0]*(-1);
        for(int i=1;i<prices.length;++i){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][1], dp[prices.length-1][2]);
    }
}