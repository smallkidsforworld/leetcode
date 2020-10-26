public class d174{
    public int calculateMinimumHP(int[][] dungeon) {
        //使用dp来记录到达每一个地点所需要的健康点数
        int n=dungeon.length,m=dungeon[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1]=dungeon[n-1][m-1]>0?0:dungeon[n-1][m-1];
        for(int i=m-2;i>=0;i--)
            dp[n-1][i]=(dp[n-1][i+1]+dungeon[n-1][i])>0?0:(dp[n-1][i+1]+dungeon[n-1][i]);
        for(int i=n-2;i>=0;i--)
            dp[i][m-1]=(dp[i+1][m-1]+dungeon[i][m-1])>0?0:(dp[i+1][m-1]+dungeon[i][m-1]);
        for(int i=n-2;i>=0;--i){
            for(int j=m-2;j>=0;--j){
                dp[i][j]=(dp[i+1][j]>dp[i][j+1]?dp[i+1][j]:dp[i][j+1])+dungeon[i][j];
                if(dp[i][j]>0)
                    dp[i][j]=0;
            }
        }  
        for(int[] d:dp){
            for(int k:d)
                System.out.print(k+" ");
            System.out.println();
        }
        return dp[0][0]>0?0:-dp[0][0]+1;
    }
    

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        d174 dd = new d174();
        System.out.println(dd.calculateMinimumHP(dungeon));
    }
}