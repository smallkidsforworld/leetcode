import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class d140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        addTheWord(s,0, s.length(), set, result);
        return result;
    }

    public void addTheWord(String s,int start, int end, Set<String> dict, List<String> result) {
        if(start>=s.length())
            return;
        
    }

}