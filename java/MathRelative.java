import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class MathRelative {
    public static int minMultipy(int m,int n){
        return m*n/maxDivide(m, n);
    }

    public static int getFreeDrink(int n){
        int result=0;
        while(n>=3){
            result++;
            n=n-2;
        }
        return (n==2)?++result:result;
    } 

    public static int tenToSisten(String str){
        String temp_str = str.split("0x")[1];
        int result=0,k=0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char t = '0';t<='9';++t)
            hashMap.put(Character.valueOf(t), Integer.valueOf(k++));
        for(char t = 'A';t<'G';++t)
            hashMap.put(Character.valueOf(t), Integer.valueOf(k++));
        for(int i=0;i<temp_str.length();++i){
            result=16*result+hashMap.get(temp_str.charAt(i));
        }
        return result;
    }
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     while(scanner.hasNext()){
    //         String current_str = scanner.nextLine();
    //         System.out.println(tenToSisten(current_str));
    //     }
    //     scanner.close();
    // }

    public static void main(String[] args) {
        String str = "0xA";
    }

    
    public static String reverseString(String input){
        char[] input_set = input.toCharArray();
        for(int i=0;i<input_set.length/2;i++){
            char temp = input_set[i];
            input_set[i]=input_set[input_set.length-1-i];
            input_set[input_set.length-1-i]=temp;
        }
        return String.valueOf(input_set);
    }


    public static void test(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int result = scanner.nextInt();
            System.out.println(result+" ");
        }
        scanner.close();
    }

    public static double setDoubleNum(int length,double nums){
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(length);
        nf.setMaximumFractionDigits(length);
        return Double.valueOf(nf.format(nums));
    }


    public static int maxDivide(int m,int n){
        while(m%n!=0){
            int temp = n;
            n=m%n;
            m=temp;
        }
       return n;
    }

    public static double getCubeRoot(double input){
        int integer_area = (int)input;
        double result = Math.abs(input);
        if(result==0)
            return 0;
        for(double i=0.1;i<input;i+=0.1){
            if(i*i*i<input&&(i+0.1)*(i+0.1)*(i+0.1)>input){
                if((i+0.05)*(i+0.05)*(i+0.05)<=input)
                    result = i+0.1;
                else
                    result=i;
            }
        }
        return input<0?result*-1:result;
    }
    
    
}