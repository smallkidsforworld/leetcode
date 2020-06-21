import java.util.HashMap;
import java.util.Map;

// 无重复字符的最长字串
//     1：使用map记录每一次扫描的值<char,location>，如果没有，就加入，如果有，更新当前节点的位置
//     2：使用start，end记录当前开始位置，和结束为止，用来记录长度。，每当更新节点位置，计算长度。
//     3：对于冲突后的map清理，我是通过增加了判断，如果命中的字符在左侧，则仅仅更新位置，否则，计算长度，更新位置，修改start
class d3{
    
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1)
            return 0;
        if(s.length()==1)
            return 1;
        Map<Character,Integer> recode = new HashMap<>();
        int start=0,end=0,maxlength=0;
        for(int i=0;i<s.length();++i){  
            if(!recode.containsKey(Character.valueOf(s.charAt(i)))){
                // System.out.println("dd: "+i);
                recode.put(Character.valueOf(s.charAt(i)), i);
            }else{
                int location = recode.get(Character.valueOf(s.charAt(i)));
                if(location>=start){
                    if(maxlength<i-start)
                        maxlength=i-start;
                    start=location+1;
                }
                // System.out.println("maxlength :"+ maxlength);
                recode.put(Character.valueOf(s.charAt(i)),i);
            }
            end=i;
        }
        maxlength=s.length()-start>maxlength?s.length()-start:maxlength;
        return maxlength;
    }

    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "bbbbb";
        // String s ="pwwkew";
        // String s ="au";
        String[] dd = new String[5];
        dd[0]="abcabcbb";
        dd[1]="bbbbb";
        dd[2]="pwwkew";
        dd[3]="au";
        dd[4]="ohomm";
        for(String s:dd)
            System.out.println(new d3().lengthOfLongestSubstring(s));
    }
}