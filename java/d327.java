public class d327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int total = 0;
        for (int i = 0; i < nums.length - 1; ++i)
            for (int j = i + 1; j < nums.length; ++j) {
                if (!judge(nums, i, j, lower, upper))
                    continue;
                total++;
            }
        return total;
    }

    private boolean judge(int[] nums, int i, int j, int lower, int upper) {
        int sum =0;
        while(i<=j)
            sum+=nums[i++];
        return (sum>=lower)&&(sum<=upper);
    }

}