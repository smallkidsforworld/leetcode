class d53{
    public int maxSubArray(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int result=nums[0],pre=0;
        for(int i=1;i<nums.length;++i){
            pre = Math.max(nums[i], pre+nums[i]);
            result=Math.max(pre, result);
        }
        return result;
    }

    public static void main(String[] args) {
        d53 temp = new d53();
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] dd= new int[]{-1,-2};
        System.out.println(temp.maxSubArray(nums));
        System.out.println(temp.maxSubArray(dd));
    }
}