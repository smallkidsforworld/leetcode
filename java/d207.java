import java.util.ArrayList;
import java.util.List;

public class d207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] judge = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;++i)
            list.add(new ArrayList<>());
        for(int[] dd:prerequisites)
            list.get(dd[1]).add(dd[0]);
        for(int i=0;i<numCourses;++i)
            if(!dfs(numCourses,judge,list))
                return false;
        return true;
    }

    

    public static boolean dfs(int i, int[] judge, List<List<Integer>> list) {
        if(judge[i]==-1)    return true;
        if(judge[i]==1) return false;
        judge[i]=1;
        for(Integer num:list.get(i))
            if(!dfs(num,judge,list)) return false;
        judge[i]=-1;
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites ={
            {1,0}
        };
        System.out.println(canFinish(numCourses, prerequisites));

    }
}