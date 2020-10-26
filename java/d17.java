import java.util.ArrayList;
import java.util.List;

public class d17{
    static char[][] index = {{},{},
            {'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},
            {'m','n','o'},{'p','q','r','s'},
            {'t','u','v'},{'w','x','y','z'}
        };
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()<=0)
            return result;
        char[] digit_str = digits.toCharArray();
        addString("",Integer.valueOf(digit_str[0]-'0'), 0,  result,digit_str);
        return result;
    }

    public static void addString(String store_str,int num,int location,List<String> result,char[] nums_set){
        for(int i=0;i<index[num].length;++i){
            if(location==nums_set.length-1)
                result.add(store_str+index[num][i]);
            else
                addString(store_str+index[num][i], Integer.valueOf(nums_set[location+1]-'0'), location+1, result,nums_set);
        }

    }

    public static void main(String[] args) {
        String temp = "23";
        for(String s:letterCombinations(temp)){
            System.out.println(s);
        }
    }
}