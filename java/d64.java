public class d64{
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0]=grid[0][0];
        for(int i=1;i<n;++i)
            dp[i][0]=dp[i-1][0]+grid[i][0];
        for(int j=1;j<m;++j)
            dp[0][j]=dp[0][j-1]+grid[0][j];
        for(int i=1;i<n;++i){
            for(int j=1;j<m;++j){
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        return dp[n-1][m-1];
    }   

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        d64 dd = new d64();
        System.out.print(dd.minPathSum(grid));

    }
}