public class d329{
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)
            return 0;
        int m=matrix.length,n=matrix[0].length,result=0;
        int[][] dp = new int[m][n];
        boolean[][] past = new boolean[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(dp[i][j]!=0)
                    continue;
                dp[i][j]=dfs(i, j, matrix, i, j, past, dp,m,n);
                if(dp[i][j]>result)
                    result=dp[i][j];
            }
        }
        return result;
    }

    public int dfs(int i,int j,int[][] matrix,int old_i,int old_j,boolean[][] past,int[][] dp,int m,int n){
        if(i<0||j<0||i>=m||j>=n||(matrix[i][j]<=matrix[old_i][old_j]&&(old_i!=i||old_j!=j))||past[i][j])
            return 0;
        if(dp[i][j]!=0)
            return dp[i][j];
        past[i][j]=true;
        int length1 = Math.max(dfs(i, j-1, matrix,i,j,past,dp,m,n), dfs(i-1, j, matrix,i,j,past,dp,m,n));
        int length2 = Math.max(dfs(i, j+1, matrix,i,j,past,dp,m,n), dfs(i+1, j, matrix,i,j,past,dp,m,n));
        past[i][j]=false;
        dp[i][j]=1+Math.max(length1, length2);
        return dp[i][j];
    }

    public void print(int[][] dp){
        System.out.println("*********");
        for(int i=0;i<dp.length;++i){
            for(int j=0;j<dp[i].length;++j)
                System.out.print(dp[i][j]);
            System.out.println();
        }
        System.out.println("*********");
    }

    public int aroundBig(int i,int j,int[][] matrix,int[][] dp){
        int a1 = judge(i-1,j,matrix,matrix[i][j])?dp[i-1][j]:-1;
        int a2 = judge(i,j-1,matrix,matrix[i][j])?dp[i][j-1]:-1;
        int a3 = judge(i+1,j,matrix,matrix[i][j])?dp[i+1][j]:-1;
        int a4 = judge(i,j+1,matrix,matrix[i][j])?dp[i][j+1]:-1;
        if(a1==a2&&a3==a4&&a1==a3&&a2==-1&&a3==-1)
            return 0;
        else
            return Math.max(Math.max(a1,a2), Math.max(a3, a4));
    }

    public boolean judge(int i,int j,int[][] matrix,int compare){
        int m=matrix.length,n=matrix[0].length;
        if(i<0||j<0||i>=m||j>=n||matrix[i][j]<compare)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };

        d329 dd = new d329();
        // System.out.println(dd.longestIncreasingPath(nums));

        int[][] numss = {
            {3,4,5},
            {3,2,6},
            {2,2,1}
        };
        // System.out.println(dd.longestIncreasingPath(numss));
        // int[][] test={{1,2},{4,3}};
        System.out.println(dd.longestIncreasingPath(nums));
    }
}
    