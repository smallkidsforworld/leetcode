import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class d350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] n1 = nums1.length>nums2.length?nums1:nums2;
        int[] n2 = nums1.length>nums2.length?nums2:nums1;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:n2)
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
        int[] intersection = new int[nums2.length];
        int index=0;
        for(int i:n1){
            int d1 = map.getOrDefault(i, 0);
            if(d1>0){
                intersection[index++]=i;
                d1--;
                if(d1<0)
                    map.remove(i);
                else
                    map.put(i, d1);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
    
    

    public static void main(String[] args) {
        // int[] nums1={4,9,5};
        // int[] nums2={9,4,9,8,4};
        int[] nums1={1,1};
        int[] nums2={1,2};
        d350 dd = new d350();
        int[] result = dd.intersect(nums1, nums2);
        for(int i:result)
        System.out.println(i);
    }

}