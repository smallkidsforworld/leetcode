import java.util.HashMap;
import java.util.Map;

class d41{

    // 
    public int firstMissingPositive(int[] nums) {
        if(nums.length<=0)
            return 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i, 0);
        for(int i=1;i<=nums.length;++i){
            if(!map.containsKey(i))
                return i;
        }
        return 0;
    }
    // 原地反转，将对应的数字填写到对应的位置
    // 对于数字x 其满足[1,length]，则位置应该在x-1这个位置上

    public int reverLocal(int[] nums){
        for(int i=0;i<nums.length;++i){
            if(1<=nums[i]&&nums[i]<=nums.length)
                swap(nums,i,nums[i]-1);
        }
        for(int i=0;i<nums.length;++i)
            if(nums[i]!=i+1) 
                return i+1;
        return 0;
    }

    public void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }

    public static void main(String[] args) {
        int[] nums={4,3,-1,1};
        System.out.println("dd "+new d41().reverLocal(nums));
    }

}