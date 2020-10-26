
public class d312{
    int result=Integer.MIN_VALUE;

    public int maxCoins(int[] nums) {
        //consider 
        //暴力方法|：全排列，然后计算value
        //dp：
        return dd(nums,0);
    }


    public int dp(int[] nums){
        if(nums.length<1)
            return 0;
        int[][] dp = new int[nums.length][nums.length];
        int[] temp = new int[nums.length+2];
        temp[0]=1;
        temp[nums.length]=1;
        System.arraycopy(nums, 0, temp, 1, nums.length);
        for(int i=nums.length-1;i>=0;--i){
            for(int j=i+2;j<=nums.length+1;++j){
                for (int k = i + 1; k < j; k++) {
                    int sum = temp[i] * temp[k] * temp[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][nums.length+1];
    }

    // String toString(int[] nums){
    //     String d ="";
    //     for(int i:nums)
    //         d+=i;
    //     return d;
    // }
    int dd(int[] nums,int values){
        // System.out.println("result"+result+" value "+values);
        // System.out.println(toString(nums));
        if(nums.length==1)
            return values+nums[0];
        
        int[] temp = new int[nums.length-1];
        for(int i=0;i<nums.length;++i){
            int value = values;
            int left=0,right=0;
            while(left<nums.length-1){
                if(right==i)
                    right++;
                temp[left]=nums[right];
                left++;
                right++;
            }
            if(i==0)
                value+=nums[0]*nums[1];
            else if(i==nums.length-1)
                value+=nums[nums.length-2]*nums[nums.length-1];
            else
                value+=nums[i-1]*nums[i]*nums[i+1];
            
            value = dd(temp,value);
            result=result>value?result:value;  
        }
        return result;
    }

    public static void main(String[] args) {
        d312 kk = new d312();
        int[] nums={7,9,8,0,7,1,3,5,5,2,3,3};
        System.out.println(kk.maxCoins(nums));
    }
}