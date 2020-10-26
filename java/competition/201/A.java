public class A {
    public String makeGood(String s) {
        int i=0;
        while(judge(s)&&i<s.length()-1){
            if(Math.abs(s.charAt(i)-s.charAt(i+1))==32){
                s=s.substring(0, i)+s.substring(i+2, s.length());
                i=0;
            }
        }
        return s;
    }    

    public boolean judge(String s){
        if(s.length()==0||s.length()==1)
            return true;
        for(int i=0;i<s.length()-1;++i){
            if(Math.abs(s.charAt(i)-s.charAt(i+1))==32)
                return false;
        }
        return true;
    }
}