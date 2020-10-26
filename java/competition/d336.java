import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class d336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i=0;i<words.length;++i)
            hashMap.put(new StringBuffer(words[i]).reverse().toString(), i);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int length = words[i].length();
            for(int j=0;j<length;j++){
                if(hashMap.containsKey(words[i])){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(hashMap.get(words[i]));
                    result.add(temp);
                }
                else if(judge(words[i],j,length-1)){
                    int left = hashMap.getOrDefault(words[i].substring(0,j),-1);
                    if(left!=-1&&left!=i){
                        result.add(Arrays.asList(i,left));
                    }
                }else if(j!=0&&judge(words[i],0,j-1)){
                    int right = hashMap.getOrDefault(words[i].substring(j,length),-1);
                    if(right!=-1&&right!=i){
                        result.add(Arrays.asList(right,i));
                    }
                }
            }
        }
        return result;
    }

    public boolean judge(String str,int start,int end){
        int length=end-start+1;
        for(int i=0;i<length/2;++i){
            if(str.charAt(start+i)!=str.charAt(end-i)){
                return false;
            }
        }
        return true;
    }
}