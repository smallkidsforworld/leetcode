import java.util.HashMap;

public class d834 {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        // 只记录父节点到子节点的val
        int[][] dp = new int[N][N];
        for (int[] i : edges) {
            dp[i[0]][i[1]] = 1;
        }
        return dp[0];

    }

    public static void main(String[] args) {
        
    }
}