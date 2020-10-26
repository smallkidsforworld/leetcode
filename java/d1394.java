import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class d1394 {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> all_key = new ArrayList<>();
        for(int i:arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                all_key.add(i);
                map.put(i,1);
            }
        }
        Collections.sort(all_key,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(Integer num :all_key){
            if(num==map.get(num))
                return num;
        }   
        return -1;
    }

    public int findL(int[] arr){
        int[] num = new int[500];
        for(int i:arr){
            num[i]++;
        }
        for(int i=num.length-1;i>0;i--)
            if(num[i]==i)
                return i;
        return -1;
    }
}