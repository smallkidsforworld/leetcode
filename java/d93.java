import java.util.ArrayList;
import java.util.List;

public class d93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(new StringBuilder(), s, 0, result,0);
        return result;
    }


    public void dfs(StringBuilder str,String s,int left,List<String> result,int num){
        if(num==3){
            if(Integer.valueOf(s.substring(left,s.length()))>255)
                return;
            else
                result.add(str.append(s.substring(left, s.length())).toString());
        }else if(num>=4||left>=s.length()-1){
            return;
        }else{
            for(int right=left+1;right<s.length();++right){
                if(Integer.valueOf(s.substring(left,right))>255||left-right>=4)
                    break;
                dfs(str.append("."+s.substring(left,right)),s,right+1,result,num+1);
            }
        }
    }
}