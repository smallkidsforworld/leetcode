
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class d1365 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = Arrays.copyOf(nums, nums.length);
        Arrays.sort(result);
        int[] map = new int[101];
        // Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (i == 0)
                map[result[i]] = 0;
            else
                map[result[i]] = result[i] != result[i - 1] ? i : map[result[i - 1]];
        for (int i = 0; i < nums.length; ++i)
            nums[i] = map[nums[i]];
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 7, 7, 7 };
        for (int i : smallerNumbersThanCurrent(nums))
            System.out.printf(" %d ", i);
    }

}