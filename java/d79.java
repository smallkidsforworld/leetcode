
public class d79{
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        boolean flag=false;
        boolean[][] judge = new boolean[m][n];
        char[] temp = word.toCharArray();
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(board[i][j]==temp[0]){
                    boolean temps=judge(i,j,0,board,temp,judge);
                    flag = flag||temps; 
                }
            }
        }
        return flag;
    }


    public boolean judge(int start,int end,int location,char[][] board,char[] word,boolean[][] judge){
        if(start>=board.length||start<0||end>=board[0].length||end<0||judge[start][end]||board[start][end]!=word[location])
            return false;
        if(location==word.length-1)
            return true;
        judge[start][end]=true;
        boolean flag1 = judge(start+1,end,location+1,board,word,judge);
        boolean flag2 = judge(start-1,end,location+1,board,word,judge);
        boolean flag3 = judge(start,end-1,location+1,board,word,judge);
        boolean flag4 = judge(start,end+1,location+1,board,word,judge);
        judge[start][end]=false;
        return flag1||flag2||flag3||flag4;        
    }

    public static void main(String[] args) {
        char[][] board ={
            {'A','B','C','E'},
            {'S','F','E','S'},
            {'A','D','E','E'}
        };
        String word="ABCESEEEFS";
        d79 dd = new d79();
        System.out.println(dd.exist(board, word));
    }
}