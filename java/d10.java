// package stack;
class d10{
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[][] f=new boolean[m+1][n+1];
        f[0][0]=true;
        for(int i=0;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(p.charAt(j-1)=='*'){
                    f[i][j]=f[i][j-2];
                    if(matchs(s, p,i,j-1))
                        f[i][j]=f[i][j]||f[i-1][j];
                }else{
                    if(matchs(s, p, i, j))
                        f[i][j]=f[i-1][j-1];
                }
            }
        }
        return f[m][n];
    }
    public boolean matchs(String a,String b,int i,int j){
        if(i==0)
            return false;
        if(b.charAt(j-1)=='.')
            return true;
        return a.charAt(i-1)==b.charAt(j-1);
    }
    public static void main(String[] args) {
        System.out.println("hhh");

        String s="ba";
        String p = ".*a";

        System.out.println(new d10().isMatch(s, p));
    }
}