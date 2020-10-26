public class d415{
    public String addStrings(String num1, String num2) {
        int len1=num1.length()-1,len2=num2.length()-1,flag=0;
        StringBuilder result= new StringBuilder();
        while(len1>=0&&len2>=0){
            int temp=num1.charAt(len1--)-'0'+num2.charAt(len2--)-'0'+flag;
            flag=temp/10;
            temp=temp%10;
            result.append(temp);
        }
        while(len1>=0){
            int temp=num1.charAt(len1--)-'0'+flag;
            flag=temp/10;
            temp=temp%10;
            result.append(temp);
        }
        while(len2>=0){
            int temp=num2.charAt(len2--)-'0'+flag;
            flag=temp/10;
            temp=temp%10;
            result.append(temp);
        }
        if(flag==1)
            result.append(1);
        return result.reverse().toString();
    }
}