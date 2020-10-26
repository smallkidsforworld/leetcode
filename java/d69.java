
class d69{
    public String addBinary(String a, String b) {
        String d1 =a.length()>=b.length()?a:b;
        String d2 =a.length()<b.length()?a:b;
        for(int i=d2.length();i<d1.length();++i)
            d2="0"+d2;
        String result="";
        int flag=0;
        for(int i=d2.length()-1;i>=0;i--){
            int[] resultarr = judge(d1.charAt(i+d1.length()-d2.length()), d2.charAt(i), flag);
            flag=resultarr[1];
            result=String.valueOf(resultarr[0])+result;
        }
        if(flag==1)
            return "1"+result;
        return result;    
    }

    // 1 means no flag and return 1
    // 0 means no flag and return 0
    // 2 means flag=1 and return 0
    // 3 means flag=1 and return 1
    

    public int[] judge(char a,char b,int flag){
        int[] result=new int[2];
        if((a=='0'&&b=='1')||(a=='1'&&b=='0')){
            result[0]=flag==0?1:0;
            result[1]=flag==1?1:0;
        }
        else if(a=='0'&&b=='0'){
            result[0]=flag==0?0:1;
            result[1]=0;
        }
        else if(a=='1'&&b=='1'){
            result[0]=flag==1?1:0;
            result[1]=1;
        }
        return result;    
    }

    public static void main(String[] args) {
        d69 dd = new d69();
        System.out.println(dd.addBinary("11", "1"));
    }
}