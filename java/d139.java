import java.util.ArrayList;
import java.util.List;

/* 单词拆分
    经典dp
    dp[i]表示以i结尾，可以拆分的字符串
    dp[j+i]=dp[i]&&wordlist.contain(substring(i,i+j))
    dp[0]=0;
    最终结果dp[n] */
class d139 {

    // bfs
    public boolean dd(String s, List<String> word){
        return check(s,word,0);
    }

    boolean check(String s ,List<String> word,int start){
        if(start>s.length()-1)
            return true;
        for(int end=start+1;end<=s.length();++end){
            if(check(s,word,end)&&word.contains(s.substring(start,end)))
                return true;
        }
        return false;
    }

    // dp
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp consider
        //dp[i] means end's with s[i] can be divide by wordDict
        if(s.length()==0&&wordDict.size()==0)
            return true;
        if(s.length()==0&&wordDict.size()!=0)
            return false;
        if(wordDict.size()==0&&s.length()!=0)
            return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<s.length()+1;++i)
            for(int j=0;j<i;++j){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String str="applepenapple";
        List<String> dd = new ArrayList<>();
        dd.add("apple");
        dd.add("pen");
        System.out.println(new d139().dd(str, dd));
    } 
}