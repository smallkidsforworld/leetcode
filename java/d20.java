import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class d20 {
    static HashMap<Character,Character> store = new HashMap<>();
    static {
    store.put(')','(');
    store.put(']','[');
    store.put('}','{');
    }

    public static boolean isValid(String s) {
        if(s.length()==1)
            return false;
        if(s.length()==0)
            return true;
        char[] ar = s.toCharArray();
        Stack<Character> stack=new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<s.length();++i){
            if(!judge(arr[i],stack))
                return false;
        }        
        return stack.size()==0;
    }

    public static boolean judge(char top,Stack<Character> stack){
        if(store.containsKey(top)){
            return stack.pop()==store.get(top);
        }else{
            stack.push(top);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
            System.out.println(isValid(scanner.nextLine()));
        scanner.close();
    }
}