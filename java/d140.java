import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Set<String> set = new HashSet<>();
        // wordDict.forEach(word -> set.add(word));
        List<String> result = new ArrayList<>();
        addTheWord(s, 0, result, "");
        return result;
    }

    public boolean addTheWord(String s, int start, List<String> result, String current) {

        if (start > s.length())
            return false;
        if (start == s.length()) {
            result.add(current);
        }
        for (int i = start; i < s.length(); ++i) {
            String temp = s.substring(start, i + 1);
            if (!result.contains(temp) && judge(s.substring(i + 1), result))
                continue;
            current += " " + temp;
            if (!addTheWord(s, start + 1, result, current))
                return false;
        }
        return true;
    }

    public boolean judge(String s, List<String> wordDict) {
        // dp consider
        // dp[i] means end's with s[i] can be divide by wordDict
        if (s.length() == 0 && wordDict.size() == 0)
            return true;
        if (s.length() == 0 && wordDict.size() != 0)
            return false;
        if (wordDict.size() == 0 && s.length() != 0)
            return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; ++i)
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new d140().wordBreak("leetcode", Arrays.asList("leet", "code")).size());
    }

}