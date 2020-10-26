
public class d45{
    public static String multiply(String num1, String num2) {
        char[] num_one = num1.toCharArray();
        char[] num_two = num2.toCharArray();
        int index_one = num_one.length-1;
        int index_two = num_two.length-1;
        int advance = 0;
        StringBuilder[] store=  new StringBuilder[num_one.length];
        for(int i=index_one;i>=0;i--){
            int temp = (num_one[i]-'0');
            store[num_one.length-1-i]=new StringBuilder();
            for(int j=index_two;j>=0;j--){
                System.out.println(" temp "+temp);
                System.out.println(" temp two "+num_two[j]);
                int current_result = temp*(num_two[j]-'0')+advance;

                System.out.println("current_value "+current_result);
                advance=current_result>9?current_result/10:0;
                store[num_one.length-1-i].append(current_result%10);
            }
            if(advance>=1)
                store[num_one.length-1-i].append(advance);
            advance=0;
        }
        String result = store[0].toString();
        if(store.length<=1)
            return store[0].reverse().toString();
        for(int i=1;i<store.length;++i){
            result=getSumOfToArray(result, store[i].toString(), i);
            System.out.println(" dd result "+result);
        }
        return new StringBuilder(result).reverse().toString();
    }

    public String deal(String input){
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)!='0')
                return input.substring(i, input.length());
        }
        return input.substring(input.length()-1, input.length());
    }

    public static void main(String[] args) {
        // System.out.println(" result "+getSumOfToArray("8631", "219", 1));
        System.out.println(multiply("9", "9"));
    }

    public static String getSumOfToArray(String one,String two,int length){
        int index_one=length;
        int index_two=0;
        char[] num_one = one.toCharArray();
        char[] num_two = two.toCharArray();
        int advance =0;
        StringBuilder result = new StringBuilder(one.substring(0, length));
        
        while(index_one<num_one.length&&index_two<num_two.length){
            int temp = (num_one[index_one]-'0')+(num_two[index_two]-'0')+advance;
            advance=temp>9?temp/10:0;
            result.append(temp%10);            
            index_one++;
            index_two++;
            System.out.println("add the num "+result.toString());

        }
        while(index_one<num_one.length){
            int temp = (num_one[index_one]-'0')+advance;
            advance=temp>9?temp/10:0;
            result.append(temp%10);
            index_one++;
        }
        while(index_two<num_two.length){
            int temp = (num_two[index_two]-'0')+advance;
            advance=temp>9?temp/10:0;
            result.append(temp%10);
            index_two++;
        }
        if(advance>0)
            result.append(advance);
        return result.toString();
    }
}