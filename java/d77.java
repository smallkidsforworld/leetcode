import java.util.ArrayList;
import java.util.List;

public class d77 {
    public List<List<Integer>> combine(int n, int k) {  
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, 0, new ArrayList<>(), k, n);
        return result;
    }

    public void dfs(List<List<Integer>> result,int start,List<Integer> value,int k,int n){
        if(value.size()>=k){
            result.add(value);
        }else{
            for(int i=start;i<=n;++i){
                value.add(i);
                dfs(result,start,value,k,n);
                value.remove(value.get(i));
            }
        }   
    }

    
}