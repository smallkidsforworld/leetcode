public class d498{
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int m = matrix.length,n=matrix[0].length;
        int[] result = new int[m*n];
        int i=0,target=0,j=0;
        while(i<m&&j<n&&target<m*n){
            result[target++]=matrix[i][j];
            System.out.println("i  "+i+" j "+j);
            if((i+j)%2==0){
                while(judge(i-1,j+1,matrix)){
                    result[target++]=matrix[i-1][j+1];
                    i--;j++;
                }
                if(j==n-1)
                    i++;
                else
                    j++;
            }else{
                while(judge(i+1,j-1,matrix)){
                    result[target++]=matrix[i+1][j-1];
                    i++;j--;
                }
                if(i==m-1)
                    j++;
                else
                    i++;
            }
        }
        return result;
    }

    static boolean judge(int i,int j,int[][] matrix){
        int m = matrix.length,n=matrix[0].length;
        if(i<0||j<0||i>=m||j>=n)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix=  {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        for(int i:findDiagonalOrder(matrix))
        System.out.print(" "+i);
    }
}