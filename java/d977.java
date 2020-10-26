import java.util.Arrays;
import java.util.Comparator;

public class d977{
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;++i){
            A[i]=A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }
}