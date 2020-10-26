class d32{
    // dp way
    public int longestValidParentheses(String s) {
        int max_length=0;
        int[] dp = new int[s.length()];
        for(int i=1;i<s.length();++i){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='(')
                    dp[i]=((i>1)?dp[i-2]:0)+2;
                else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='(')
                    dp[i]=dp[i-1]+((i-dp[i-1])>1?(dp[i-dp[i-1]-2]):0)+2;
            }
            max_length=Math.max(dp[i], max_length);
        }
        return max_length;
    }
}