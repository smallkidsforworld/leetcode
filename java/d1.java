public class d1{
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]<target){
                left++;
            }else if(numbers[left]+numbers[right]>target){
                right--;
            }else
                return new int[]{left,right};
        }
        return null;
    }
}