public class d171{
    public int titleToNumber(String s) {
        char[] all_char = s.toCharArray();
        int result = 0;
        for(int i=0;i<s.length();i++)
            result+=(s.length()-1-i==0)?all_char[i]-'A'+1:Math.pow( 26,(s.length()-1-i))*(all_char[i]-'A'+1);
        return result;
    }

    // 26 - 10

    public int dd(char[] dd,int time){
        if(time==dd.length- 1){
            return dd[time]-'A'+1;
        }else{
            return 26*(dd[time]-'A'+1)*dd(dd,time+1);
        }
    }


    public static void main(String[] args) {
        String t1 = "AA";
        String t2 = "A";
        String t3= "AAA";
        d171 dd  = new d171();
        System.out.println(dd.titleToNumber(t1)==dd.dd(t1.toCharArray(),0));
        System.out.println(dd.titleToNumber(t2)==dd.dd(t2.toCharArray(),0));
        System.out.println(dd.titleToNumber(t3)==dd.dd(t3.toCharArray(),0));

        System.out.println(dd.dd(t3.toCharArray(),0));
    }


}

