package competition;

public class d130 {
    public void solve(char[][] board) {
        //深度优先搜索，将非边界上的所有可行点为O的点置位D
        //第二次便利，将所有O写作X，所有D，写作O               
         for(int i=0;i<board.length;++i){
             if(board[i][0]=='O')
                 dfs(board,i,0);
             if(board[i][board[0].length-1]=='O')
                 dfs(board,i,board[0].length-1);
         }
         for(int i=0;i<board[0].length;++i){
             if(board[0][i]=='O'){
                 dfs(board,0,i);
             }
             if(board[board.length-1][i]=='O')
                 dfs(board,board.length-1,i);
                 
         }
 
         for(int i=0;i<board.length;++i)
             for(int j=0;j<board[i].length;++j)
                 if(board[i][j]=='O')
                     board[i][j]='X';
                 else if(board[i][j]=='D')
                     board[i][j]='O';
     }
 
     public void dfs(char[][] board,int x,int y){
         if(x<0||y<0||x>=board.length||y>=board[0].length||board[x][y]=='X')
             return;
         if(board[x][y]=='O'){
             // if((x!=board.length-1||x!=0)&&(y!=0&&y!=board[0].length-1))
             //     return;
             // else{
                 board[x][y]='D';
             // }
             dfs(board,x+1,y);
             dfs(board,x-1,y);
             dfs(board,x,y+1);
             dfs(board,x,y-1);
         }
     }    
}
