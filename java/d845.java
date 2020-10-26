

public class d845 {
    public static int longestMountain(int[] A) {
        if(A.length<3)
            return 0;
        int[][] dp = new int[A.length][2];
        // 对任意一个位置,可能有三种情况,左峰,中间,右峰.
        // 暴力算法,每个作为中锋,取得符合条件的最大值.
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max_len = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = 1;
            } else if (A[i] < A[i - 1]) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]) + 1;
                dp[i][0] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
            max_len = max_length(dp[i][0], dp[i][1], max_len);
        }
        
    }

    public static int max_length(int... num) {
        int max = num[0];
        for (int i : num)
            max = Math.max(i, max);
        return max;
    }
    public static void main(String[] args) {
        int[] test = new int[] { 2, 2, 2 };
        System.out.println(longestMountain(test));
    }
}