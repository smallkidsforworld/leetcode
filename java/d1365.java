package java;

import java.util.Arrays;

public class d1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = Arrays.copyOf(nums,nums.length);
        Arrays.sort(result);
        

        return result;
    }

}