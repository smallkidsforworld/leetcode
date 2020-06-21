package stack;

import java.util.Stack;

class d20 {
    public boolean isValid(String s) {
        if(s.length()==1)
            return false;
        if(s.length()==0)
            return true;
        char[] arr = s.toCharArray();
        Stack<Character> stack=new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<s.length();++i){
            if(!judge(arr[i],stack))
                return false;
        }        
        return stack.size()==0;
    }

    public boolean judge(char top,Stack<Character> stack){
        switch(top){
            case ')':
                if(!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                    return true;
                }else 
                    return false;
            case ']':
                if(!stack.isEmpty()&&stack.peek()=='['){
                    stack.pop();
                    return true;
                }else 
                    return false;
            case '}':
                if(!stack.isEmpty()&&stack.peek()=='{'){
                    stack.pop();
                    return true;
                }else 
                    break;
            default:
                stack.push(top);
                return true;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "[])";
        System.out.println(new d20().isValid(s));
    }
    
}