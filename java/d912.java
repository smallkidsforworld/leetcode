import java.util.Stack;

public class d912{
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        if(S.length()<=0)
            return 0;
        int res=0;
        char[] dd = S.toCharArray();
        for(char temp:dd){
            if(temp=='(')
                stack.push(temp);
            else{
                if(!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
                else
                    res++;
            }
        }
        res+=stack.size();
        return res;
    }
}