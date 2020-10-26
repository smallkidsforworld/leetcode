class d378{
    // 二分法
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0],r=matrix[n-1][n-1];
        int mid ,cnt =0;
        while(l<r){
            mid = (r-l)/2+l;
            cnt = countless(matrix,mid);
            if(cnt<k) l=mid+1;
            else r= mid;
        }

        return l;
    }

    public int countless(int[][] matrix, int val) {
        int n = matrix.length;
        int i=n-1,j=0,res=0;
        while(i>=0&&j<n){
            if(matrix[i][j]<=val){
                res+=i+1;
                j++;
            }else
                i--;
        }
        return res;
    }
}