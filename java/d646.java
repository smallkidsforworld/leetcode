import java.util.Arrays;
import java.util.Comparator;

public class d646 {
    public static int findLongestChain(int[][] pairs) {
        if(pairs.length==0)
            return 1;
        int m=pairs.length,max=1;
        Arrays.sort(pairs,new Comparator <int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[1]-o2[1]; 
            }
        });
        int[][] dp = new int[m][m];
        for(int i=0;i<m;++i){
            int current_max=i;
            for(int j=i;j<m;++j){
                if(pairs[current_max][1]<pairs[j][0]){
                    dp[i][j]=dp[i][current_max]+1;
                    current_max=j;
                    max=Math.max(dp[i][j],max);
                }
                else
                    dp[i][j]=1;
            }
        }
        System.out.println("**************8");
        for(int[] d:dp){
            for(int k:d)
                System.out.print(k+" ");
            System.out.println();
        }
        System.out.println("**************8");
        return max;
    }

    boolean judge(int i,int j,int[][] pairs){
        if(pairs[i][1]<pairs[j][0])
            return true;
        else return false;
    }



    public void sort(int[][] pairs){

    }

    public static void main(String[] args) {
        int[][] pairs={
            {7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}
        };
        Arrays.sort(pairs,new Comparator <int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[1]-o2[1]; 
            }
        });
        
        for(int[] d:pairs){
            for(int k:d)
                System.out.print(k+" ");
            System.out.println();
        }
        System.out.println(findLongestChain(pairs));
    }
}