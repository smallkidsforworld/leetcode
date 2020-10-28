import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class d1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i,map.getOrDefault(i, 0)+1);
            // if (!map.containsKey(i))
            //     map.put(i, 1);
            // else
            //     map.put(i, map.get(i) + 1);
        return map.size() == new HashSet<>(map.values()).size();
        // Set<Integer> d = new HashSet<>();
        // for (Integer key : map.keySet())
        //     if (d.contains(map.get(key)))
        //         return false;
        //     else
        //         d.add(map.get(key));
        // return true;
    }
}