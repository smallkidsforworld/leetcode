// 最佳观光组合：
//     思路：变换公式为A[i]+i+A[j]-j
//     1：暴力法，便利数组两遍从而获得最佳答案
//     2：db。遍历右侧的值A[j]+j同时，记录当前位置左侧的最大A[i]+i，判断二者和与result大小。
class d1014{
    public int fmaxDcoreSightseeingPair(int[] A){
        int result=0;
        for(int i=0;i<A.length-1;++i){
            for(int j=i+1;j<A.length;++j){
                int dd = A[i]+A[j]+i-j;
                result = dd<result?result:dd;
            }

        }
        return result;
    }

    // dp way
    public int dbmaxDcoreSightseeingPair(int[] A){
        int result=Integer.MIN_VALUE;
        int leftmax=A[0],rightmax=0;
        for(int i=1;i<A.length;++i){
            rightmax=A[i]-i;
            leftmax=Math.max(leftmax, A[i-1]+i-1);
            result=Math.max(result, rightmax+leftmax);
        }
        
        return result;
    }


    public static void main(String[] args) {
        int[] A=new int[]{8,1,5,2,6};
        int result = new d1014().fmaxDcoreSightseeingPair(A);
        System.out.println(result);
        result = new d1014().dbmaxDcoreSightseeingPair(A);
        System.out.println(result);
        
    }
}