class d44{
    // * -> all string  ? -> single char
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        if((s.length()==0&&p.length()==0)||p.equals("?"))
            return true;
        else if(s.length()==0)
            return false;
        dp[0][0]=true;
        for(int i=1;i<p.length();++i){
            if(p.charAt(i-1)=='*')
                dp[0][i]=true;
            else break;
        }
        for(int i=1;i<=s.length();++i)
            for(int j=1;j<=p.length();++j){
                if(p.charAt(j-1)=='?'||s.charAt(i-1)==p.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
                System.out.println(" i "+i+" j "+j+" value "+ dp[i][j]);
            }
        System.out.println("fuck "+dp[s.length()][p.length()]);
                
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        d44 d1 = new d44();
        d1.isMatch(s, p);

    }
}