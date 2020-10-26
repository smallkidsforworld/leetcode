import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class d763 {
    public static List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++)
            map[S.charAt(i)-'a']=i;
        int last = 0,max=0;
        for (int i = 0; i < S.length(); ++i) {
            max=Math.max(map[S.charAt(i)-'a'], max);
            if (map[S.charAt(i)-'a'] == i&&i==max) {
                result.add(i - last + 1);
                last = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (Integer s : partitionLabels("ababcbacadefegdehijhklij"))
            System.out.println(s);

    }
}