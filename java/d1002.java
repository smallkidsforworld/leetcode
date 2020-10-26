import java.util.ArrayList;
import java.util.List;

public class d1002 {
    static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[][] recode = new int[A.length][26];
        int index=0;
        for(String str:A){
            for(char s:str.toCharArray())
                recode[index][s-'a']++;
            index++;
        }
        index--;
        for(int i=0;i<26;++i){
            if(recode[index][i]==0)
                continue;
            int k=index-1,min=recode[index][i];
            while(k>=0){
                if(min>recode[k][i])
                    min=recode[k][i];
                k--;
            }
            while(min>0){
                result.add(String.valueOf((char)('a'+i)));
                min--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] test = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        for(String s:commonChars(test))
            System.out.println(s);
    }
}