import java.util.Arrays;

public class d31 {
    public static void nextPermutation(int[] nums) {
        // 找到第一个可更换的数值:后面存在且仅存在一个比当前数大的值.
        int left = nums.length - 1;
        if (judgeWhetherMax(nums)) {
            Arrays.sort(nums);
            return;
        }
        while (left > 0) {
            if (nums[left - 1] < nums[left]) {
                for (int i = nums.length - 1; i >= left; --i)
                    if (nums[i] > nums[left - 1]) {
                        int temp = nums[left - 1];
                        nums[left - 1] = nums[i];
                        nums[i] = temp;
                    }
                Arrays.sort(nums, left, nums.length);
                return;
            }
            left--;
        }
    }

    public static boolean judgeWhetherMax(int... nums) {
        if (nums.length <= 1)
            return true;
        for (int i = 1; i < nums.length; ++i)
            if (nums[i - 1] < nums[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {  2,3,1 };
        nextPermutation(nums);
        for(int i:nums)
            System.out.print(i+" ");
    }
}