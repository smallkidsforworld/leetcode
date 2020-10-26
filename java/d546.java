import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class d546 {
    public int removeBoxes(int[] boxes) {
        int ans = 0;
        List<List<Integer>> result = new ArrayList<>();
        // for()
        int temp = boxes[0],i=1;
        while(i<boxes.length){
            int count = 0;
            while(boxes[i]==temp){
                count++;
                i++;
            }
            result.add(Arrays.asList(temp,count));
            temp=boxes[i];
        }
        Collections.sort(result, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });
        
        return ans;
    }
}