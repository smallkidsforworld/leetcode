import java.util.Arrays;
import java.util.Comparator;

public class d973 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                double sum1 = getDistance(o1);
                double sum2 = getDistance(o2);
                if (sum1 > sum2)
                    return 1;
                else if (sum1 < sum2)
                    return -1;
                else
                    return 0;
            }

        });
        int[][] result = new int[K][2];
        for (int i = 0; i < K; ++i)
            result[i] = points[i].clone();
        return result;
    }

    public static double getDistance(int... a) {
        int sum = 0;
        for (int i : a)
            sum += Math.pow(i, 2);
        return Math.sqrt(sum);
    }

}