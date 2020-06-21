import java.util.Stack;

class d224{
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int i=0,left_num=0;
        while(i<s.length()){
            int temp_num=0;
            if(Character.isDigit(s.charAt(i))){
                while(Character.isDigit(s.charAt(i))){
                    temp_num=temp_num*10+Integer.valueOf(s.charAt(i));
                    i++;
                }
                num.push(temp_num);
                continue;
            }
            if(s.charAt(i)=='('){
                operator.push(s.charAt(i));
                left_num++;
            }else if(s.charAt(i)==')'){
                while(operator.peek()!='('){
                    cal(num,operator.pop());
                }
                operator.pop();
                left_num--;
            }
            else if(s.charAt(i)!=' '){
                operator.push(s.charAt(i));
                if(left_num!=0)
                    cal(num,operator.pop());
            }
            i++;
        }

        return num.peek();
    }


    public void cal(Stack<Integer> nums,char op){
        int num1 = nums.pop();
        int num2 = nums.pop();
        
        switch(op){
            case '+':
            nums.push(num2+num1);
            break;
            case '-':
            nums.push(num2-num1);
            break;
            case '*':
            nums.push(num2*num1);
            break;
            case '/':
            nums.push(num2/num1);
            break;
        }
    }

    public static void main(String[] args) {
        int dd = new d224().calculate("1+1");
        System.out.println(dd);
    }
}