
import java.util.Arrays;
import java.util.Comparator;

public class d1024 {
    public static int videoStitching(int[][] clips, int T) {
        // 考虑根据结束字段进行排序。
        // 每次结果必定包含0,T
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });

        // 考虑贪心策略:
        int current_start = 0, current_max = 0, current_time = 0, last_time = 0;
        for (int i = 0; current_max<T; ++i) {
            if (clips[i][0] <= current_max && clips[i][1] > current_max) {
                if (clips[i][0] == current_start && current_max == 0) {
                    current_time++;
                    current_max = clips[i][1];
                    last_time=0;
                }else{
                    if(clips[i][0]>last_time){
                        last_time=current_max;
                        current_time++;
                    }
                current_max=clips[i][1];
                }
            }
        }
        if(current_max<T)
            return -1;
        return current_time;
    }

    public static void main(String[] args) {
        int[][] clips = new int[][] { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
        System.out.println(videoStitching(clips, 10));
    }

}