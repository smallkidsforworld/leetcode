class df1618{
    public boolean patternMatching(String pattern, String value) {
        int la=0,lb=0,na=0,nb=0,flag=0;
        flag=pattern.charAt(0)=='a'?1:0;
        for(int i=0;i<pattern.length();++i){
            if(pattern.charAt(i)=='a')
                na++;
            if(pattern.charAt(i)=='b')
                nb++;
        }
        System.out.println("na : "+na+" nb :"+nb);
        for(la=0;la<value.length()/na;++la){
            lb = (value.length()-na*la)/nb;
            double d = (double)(value.length()-na*la)/nb;
            if(Math.abs(d-lb)>1e-6)
                continue;
            if(!judge(la,lb,flag,value,pattern))
                return false;
        }
        return true;
    }

    boolean judge(int la,int lb,int flag,String value,String pattern){
        String va=null,vb=null;
        int index_value=0,index_pattern=0;
        if(flag==1){
            va = value.substring(0,la);
        }else{
            vb = value.substring(0,lb);
        }
        while(index_value<value.length()&&index_pattern<pattern.length()){
            if(pattern.charAt(index_pattern)=='a'){
                if(va!=null&&!value.substring(index_value,index_value+la).equals(va))
                    return false;
                if(va==null) va=value.substring(index_value,index_value+la);
                index_value+=la;
            }else{
                if(vb!=null&&!value.substring(index_value,index_value+lb).equals(vb))
                    return false;
                if(vb==null) vb=value.substring(index_value,index_value+lb);
                index_value+=lb;
            }
            index_pattern++;
        }
        System.out.println(va+" va ::"+index_pattern+"   ");
        if(index_pattern!=pattern.length()||index_value!=value.length())
            return false;
        return true;
    }

    public static void main(String[] args) {
        df1618 dd = new df1618();
        String pattern = "abab";
        String value = "catdogcatdog";
        System.out.println(dd.patternMatching(pattern,value));
        //  ax+by=c  3x+2y = 20
        // int y=0;
        // for(int x=0;x<20/3;++x){
        //     double d = (double)(20-3*x)/2;
        //     y = (20-3*x)/2;
        //     if(Math.abs(d-y)>1e-6)
        //         continue;
            // System.out.println(" x = "+x+" y = "+y);
        // }
    }


}