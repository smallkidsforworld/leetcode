import java.util.Arrays;
import java.util.stream.Collectors;

public class d1356 {
    public int[] sortByBits(int[] arr) {
        // 一个数中1的个数与
        Integer[] d = (Integer[]) Arrays.stream(arr).boxed().collect(Collectors.toList()).toArray();
        Arrays.sort(d, (o1, o2) -> {
            if (count_one(o1) != count_one(o2))
                return count_one(o1) - count_one(o2);
            else
                return o1 - o2;
        });
        for (int i = 0; i < arr.length; ++i)
            arr[i] = d[i];
        return arr;
    }

    int count_one(int a) {
        int cnt = 0;
        while (a != 0) {
            a = a & (a - 1);
            cnt++;
        }
        return cnt;
    }
}