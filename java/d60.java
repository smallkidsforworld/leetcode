import java.util.HashMap;

public class d60{
    public static String getPermutation(int n, int k) {
        int dd = getTheMult(n-1);
        int num = k/dd+1;
        int time = num%dd;
        int[] num_arr = new int[n];
        num_arr[0]=num;
        System.out.println("num:"+num+" time:"+time);
        for(int i=1,j=1;i<n;++i){
            if(j==num)
                j++;
            num_arr[i]=j++;
        }
        HashMap
        return dfs(num_arr, n, 1, k,String.valueOf(num),time);
    }



    public static void main(String[] args) {
        System.out.print(getPermutation(3, 3));
    }

    public static int getTheMult(int num){
        if(num==0||num==1)
            return 1;
        else 
            return num*getTheMult(num-1);
    }

    public static String dfs(int[] array,int n,int start,int k,String value,int num){
        if(num==k&&value.length()==n)
            return value;
        else if(value.length()==n)
            return ""; 
        else if(start>=n)
            return "";
        for(int i=start;i<n;++i){
            swap(array,start,i);
            String dd = dfs(array, n, start, k, value+array[start], num);
            if(dd.length()>0)
                return dd;
            swap(array,start,i);
        }
        return "";
            
    }

    public static void swap(int[] array,int left,int right){
        int temp = array[left];
        array[left]=array[right];
        array[right]=temp;
    }
}