package competition.One99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class D {
    public int getLengthOfOptimalCompression(String s, int k) {
        char[] temp = s.toCharArray();
        HashMap<Integer,Character> map= new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();
        int res=1;
        char current=temp[0];
        for(int i=1;i<temp.length;++i){
            if(current==temp[i]){
                res++;
            }else{
                list.add(res);
                map.put(res, current);
                res=1;
                current=temp[i];
            }
        }
        Collections.sort(list);
        List<Integer> result_list=list.subList(0,k);
        res=0;
        for(int i:result_list){
            res+=1+String.valueOf(i).length();
        }
        return res;
    }
}