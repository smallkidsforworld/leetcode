import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class d392{
    public boolean isSubsequence(String s, String t) {
        int left=0,right=0;
        while(left<s.length()&&right<t.length()){
            if(s.charAt(left)!=t.charAt(right)){
                right++;
            }else{
                left++;
                right++;
            }
        }
        return left==s.length();
    }


    public static void main(String[] args) {
        System.out.println(new d392().isSubsequence("abc", "aachbgd"));
    }
}
