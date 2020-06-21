class d5 {
    public String centerlongestPalindrome(String s) {
    
    }



    // 回文动态规划：
    // 1：如果一个字符串首尾不相等，则肯定不是字符串
    // 2：如果一个字符串的首尾相等：
    //     1：如果内部的子串是回文串，则整体回文串
    //     2：否则，不是回文串
    // 定义状态：dp[i][j]表示子串s[i……j]是否为回文子串。
    // dp[i][j]=(s[i]==s[j])&&dp[i+1][j-1]
    // dp[i][i]=true
    // 当j-i<3且首尾相同的时候，必有dp[i][j]=true
    public String dplongestPalindrome(String s) {
        if(s.length()<2)
            return s;
        int maxlength=1;
        int begin=0;
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();++i)
            dp[i][i]=true;
        for(int j=1;j<s.length();++j){
            for(int i=0;i<j;++i){
                if(s.charAt(i)!=s.charAt(j))
                    dp[i][j]=false;
                else{
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]==true&&j-i+1>maxlength){
                    maxlength=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin, begin + maxlength);

    }

    // 回文暴力法：通过//
    public String forcewaytosolve(String s) {
        if(s.length()<=1)
            return s;
        if(s.length()==2)
            if(s.charAt(0)==s.charAt(1)) 
                return s;
            else 
                return s.charAt(0)+"";
        int maxlength=0,startindex=0;
        for(int i=0;i<s.length()-1;++i){
            int length=maxsymmetrylength(i, s);
            if(length>maxlength){
                maxlength=length;
                startindex=i;
            }
        }
        String result = maxlength%2==0?s.substring(startindex-(maxlength-2)/2, startindex+1+(maxlength-2)/2+1):
        s.substring(startindex-(maxlength-1)/2,startindex+(maxlength-1)/2+1);
        return result;
    }

    int maxsymmetrylength(int index,String s){
        if(index==0){
            if(s.charAt(index)==s.charAt(index+1))
                return 2;
            else
                return 1;
        }
        int evenlength=0;
        if(s.charAt(index)==s.charAt(index+1)){
            evenlength=2;
            for(int k=1;k<=index&&k<s.length()-index-1;++k){
                if(s.charAt(index-k)==s.charAt(index+k+1))
                    evenlength+=2;
                else
                    break;
            }
        }
        int maxlength=1;
        for(int i=1;i<=index&&i<s.length()-index;++i){
            if(s.charAt(index-i)==s.charAt(index+i)){
                maxlength+=2;
            }
            else{
                return evenlength>maxlength?evenlength:maxlength;
            }
        }
        return evenlength>maxlength?evenlength:maxlength;
    }

    

    public static void main(String[] args) {
    }

}