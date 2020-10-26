class d718{
    // dp dp[i][j]=dp[i-1][j-1]+1  A[i-1]==B[j-1]
    // dp[i][j]=0  A[i-1]!=B[j-1]
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][A.length+1];
        int result =0;
        for(int i=1;i<=A.length;++i){
            for(int j=1;j<=B.length;++j){
                if(A[i-1]!=B[j-1])
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j-1]+1;
                if(dp[i][j]>result)
                    result=dp[i][j];
            }
        }
        return result;
    }
}