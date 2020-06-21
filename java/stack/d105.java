import java.util.Stack;

class d105{
    public int evalRPN(String[] tokens) {
        Stack<Integer> value = new Stack<>();
        for(String s:tokens){
            if((s.charAt(0)=='-'&&s.length()>1)||(s.charAt(0)>='0'&&s.charAt(0)<='9'))
                value.push(Integer.valueOf(s));
            else{
                int i1 = value.pop();
                int i2 = value.pop();
                    
                switch(s.charAt(0)){
                    case '+':
                        value.push(i2+i1);
                        break;
                    case '-':
                        value.push(i2-i1);
                        break;
                    case '*':
                        value.push(i2*i1);
                        break;
                    case '/':
                        value.push(i2/i1);
                        break;
                }
            }
        }
        return value.peek();
    }
}