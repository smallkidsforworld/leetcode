package competition.TheTwoHundred;

public class C {
    public int minSwaps(int[][] grid) {
        int[] dd=new int[grid.length];
        for(int i=0;i<grid.length;++i){
            for(int j=grid.length-1;j>=0;--j){
                if(grid[i][j]==0)
                    dd[i]++;
                else
                    break;
            }
        }
        int res=0;
        for(int i=0;i<dd.length;++i){
            if(dd[i]>=grid.length-i-1){
                continue;
            }else{
                boolean flag=false;
                for(int j=i+1;j<grid.length;++j){
                    if(dd[j]>=grid.length){
                        for(int k=j;k>i;--k){
                            res++;
                            swap(dd,k,k-1);
                        }
                        flag=true;
                        break;
                    }
                }
                if(!flag)
                    return -1;
            }
        }
        return res;
    }
    public void swap(int[] grid,int i,int j){
        int temp = grid[i];
        grid[j]=grid[i];
        grid[i]=temp;
    }



    public static void main(String[] args) {
        int[][] grid={
            {1,0,0,0,0,0},
            {0,1,0,1,0,0},
            {1,0,0,0,0,0},
            {1,1,1,0,0,0},
            {1,1,0,1,0,0},
            {1,0,0,0,0,0}
        };
    }
}