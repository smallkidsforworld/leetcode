public class D {
    public int minCost(int n, int[] cuts) {
        
    }   

    public int dfs(int n,int[] cuts,int total_value,int time){
        if(time==cuts.length)
            return total_value;
        for(int i=time;i<cuts.length;++i){
            swap(cuts,time,i);
            dfs(n, cuts, total_value, time+1);

            swap(cuts,time,i);
            
        }
    }

    public void swap(int[] nums,int start,int end){
        int temp = nums[end];
        nums[end]=nums[start];
        nums[start]=temp;
    }
}