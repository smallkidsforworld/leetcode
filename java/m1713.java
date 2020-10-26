import java.util.HashSet;
import java.util.Set;

public class m1713{
    public int respace(String[] dictionary, String sentence) {
        Set<String> recode = new HashSet<>();
        for(String s:dictionary)
            recode.add(s);
        int[] dp = new int[sentence.length()+1];
        for(int i=0;i<=sentence.length();i++){
            dp[i]=dp[i-1]+1;
            for(int j=0;j<i;j++){
                if(recode.contains(sentence.substring(j,i))){
                    dp[i]=Math.min(dp[j], dp[i]);
                }
            }
        }
        return dp[sentence.length()];
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"frrrbbrrbfrfqqbbbrb","qr","b","rf","qqbbbbfrqbrrqrffbrqqqbqqfqfrr","r","ffqq","bffbqfqqbrrrf","fq","qfr","fr","rqrrbfbfq","r","f","qbqbrbrbqfqbbbfbbbfbq","bqqbbbqrbbrf","f"};
        // {"potimzz"};
        
        // {"sssjjs","hschjf","hhh","fhjchfcfshhfjhs","sfh","jsf","cjschjfscscscsfjcjfcfcfh","hccccjjfchcffjjshccsjscsc","chcfjcsshjj","jh","h","f","s","jcshs","jfjssjhsscfc"};
        String sentence = "bqqffbqbbfqrfrrrbbrrbfrfqqbbbrbfqfffffrfqfqfffffrrfqfrrqbqfrbfrqqrfrbrbbqbqbqqfqrfbfrfr";
// "potimzzpotimzz";
        // "sssjjssfshscfjjshsjjsjchffffs";
        m1713 dd = new m1713();
        System.out.println(dd.respace(dictionary, sentence));

    }
}