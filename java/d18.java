import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d18 {
    //深度优先递归判断是否可行，可行加入结果集。利用结果进行剪支。\
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,nums,null,0,0,target);
        return result;
    }

    public static boolean dfs(List<List<Integer>> result,int[] nums,List<Integer> temps,int length,int value,int target){
        List<Integer> temp = temps;
        if(value!=target&&length>=4)
            return false;
        else if(value==target&&length==4){
            result.add(temp);
            return true;
        }
        for(int i=length;i<nums.length;++i){
            if(length==0){
                temp = new ArrayList<>();
            }
            swap(nums,length,i);
            temp.add(nums[length]);
            boolean flag = dfs(result,nums,temp,length+1,value+nums[length],target);
            if(flag==true)
                return true;
            else{
                temp.remove(temp.lastIndexOf(nums[length]));
                swap(nums,length,i);
            }
        }
        return false;
    }

    public static void dfs(char[] s,String result, int length){
        if(length==3){
            System.out.println(result);
            return;
        }
        for(int i=length;i<s.length;++i){
            swap(s, length, i);
            dfs(s,result+s[length],length+1);
            swap(s, length, i);

        }

    }

    public static void swap(char[] nums,int start,int end) {
        char temp = nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }


    public static void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        System.out.println(input[input.length-1].length());
        scanner.close();
    }
    

}