import java.util.Arrays;
import java.util.Comparator;

public class d406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        // int index = 0;
        // for (int[] id : people) {
            
        //     System.out.println("(" + id[0] + "," + id[1] + ")");
        //     index++;
        // }
        for (int i = 0; i < people.length; ++i)
            if (getTheNumOfBig(people, i) != people[i][1] ) {
                int distance = getTheNumOfBig(people, i) - people[i][0];
                int j = i + 1;
                while (distance >= 0 && j < people.length) {
                    if (people[j][1] >= people[i][1])
                        distance--;
                }
                System.out.print(getTheNumOfBig(people, i)+" \t");
                for (int k = j; k > i; --k)
                    swap(people, k, k - 1);
            }

        return people;
    }

    public int getTheNumOfBig(int[][] people, int index) {
        if (index == 0)
            return 0;
        int num = 0;
        for (int i = 0; i < index; i++) {
            if (people[i][0] >= people[index][0])
                num++;
        }
        return num;
    }

    public void swap(int[][] num, int i, int j) {
        int temp_A = num[i][0], temp_B = num[i][1];
        num[i][0] = num[j][0];
        num[i][1] = num[j][1];
        num[j][0] = temp_A;
        num[j][1] = temp_B;
    }

    public static void main(String[] args) {
        d406 d = new d406();
        d.reconstructQueue(new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } });
    }
}