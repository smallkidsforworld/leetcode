public class d941 {
    public static boolean validMountainArray(int[] A) {
        int top = A[0], j = 1;
        for (; j < A.length; ++j) {
            if (A[j] > top)
                top = A[j];
            else if (A[j] == top)
                return false;
            else
                break;
        }
        if(j==1)
            return false;
        for (++j; j < A.length; ++j) {
            if (A[j] < top)
                top = A[j];
            else
                return false;
        }
        if (j != A.length)
            return false;
        return true;
    }

    public static void main(String[] args) {
        
    }

}