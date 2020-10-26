import java.util.ArrayList;
import java.util.List;

public class d120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int maxlevel=triangle.size(),result=Integer.MAX_VALUE;
        if(maxlevel==1)
            return triangle.get(0).get(0);
        int[][] dp = new int[maxlevel][maxlevel];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<maxlevel;++i){
            for(int j=0;j<triangle.get(i).size();++j){
                if(j==0)
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                else if(j==(triangle.get(i).size()-1))
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                else
                    dp[i][j]=(dp[i-1][j]<dp[i-1][j-1]?dp[i-1][j]:dp[i-1][j-1])+triangle.get(i).get(j);
                if((i==maxlevel-1)&&dp[i][j]<result)
                    result = dp[i][j];
            }
        }
        // int result = result(1,maxlevel,0,triangle.get(0).get(0),triangle);
        return result;
    }

    public int result(int level,int maxlevel,int index,int value,List<List<Integer>> triangle){
        if(level==maxlevel)
            return value;
        int left = result(level+1,maxlevel,index,value+triangle.get(level).get(index),triangle);
        int right = result(level+1,maxlevel,index+1,value+triangle.get(level).get(index+1),triangle);
        System.out.println(left);
        System.out.println(right);
        System.out.println("helo ");
        return left<right?left:right;
    }


    public static void main(String[] args) {
        List<List<Integer>> dd= new ArrayList<>();
        List<Integer> d1 = new ArrayList<>();
        d1.add(-1);
        List<Integer> d2 = new ArrayList<>();
        d2.add(-2);
        d2.add(-3);
        dd.add(d1);
        dd.add(d2);
        

        d120 d = new d120();
        System.out.println(d.minimumTotal(dd));
    }

}