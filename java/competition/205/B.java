import java.util.Arrays;

public class B {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0,left,right;
        if(nums2.length>=2){
            left=0;
            right=nums2.length-1;
            for(int i : nums1){
                while(left<right){
                    if(nums2[left]>i){
                        break;
                    }
                    int rd = nums2[left]*nums2[right]-i*i;
                    if(rd==0){
                        res++;
                        left++;
                    }else if(rd<0){
                        left++;
                    }else if(rd>0){
                        right--;
                    }
                }
            }
        }
        if(nums1.length>=2){
            left=0;
            right=nums1.length-1;
            for(int i : nums2){
                while(left<right){
                    if(nums1[left]>i){
                        break;
                    }
                    int rd = nums1[left]*nums1[right]-i*i;
                    if(rd==0){
                        System.out.println(" left "+left+" "+nums1[left]);
                        System.out.println(" right "+right+" "+nums1[right]);
                        res++;
                        left++;
                    }else if(rd<0){
                        left++;
                    }else if(rd>0){
                        right--;
                    }
                }
            }
        }
        return res;
    }    
    public static void main(String[] args) {
        System.out.println(new B().numTriplets(new int[]{43024,99908},new int[]{1864}));
    }
}