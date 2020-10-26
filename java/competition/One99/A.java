package competition.One99;

import java.util.HashMap;

import sun.launcher.resources.launcher;

public class A {
    public String restoreString(String s, int[] indices) {
        HashMap<Integer,Character> hashMap = new HashMap<>();
        char[] temp = s.toCharArray();
        for(int i=0;i<s.length();++i)
            hashMap.put(indices[i], temp[i]);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();++i){
            stringBuilder.append(hashMap.get(i));
        }

        return stringBuilder.toString();
    }
}