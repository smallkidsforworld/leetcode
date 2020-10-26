public class d35{
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1,middle;
        while(left<right){
            middle = (right-left)/2+left;
            if(nums[middle]<target){
                left=middle+1;
            }else if(nums[middle]>target)
                right=middle-1;
            else
                return middle;
        }
        int kk = left>right?(right>0?right:0):(left>0?left:0);
        for(int i=kk;i<(left>right?left:right);++i){
            if(nums[i]>target)
                return i-1;
        }
        return left>right?left:right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,7,9,10};
        d35 dd = new d35();
        System.out.println(dd.searchInsert(nums, 8));
    }
}