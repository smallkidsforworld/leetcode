
public class A {
    public String modifyString(String s) {
        char[] str = s.toCharArray();
        if(s.length()==1){
            if(str[0]=='?')
                return "a";
        }
        for(int i=0;i<str.length;++i){
            if(str[i]=='?'){
                for(char k = 'a';k<='z';k++){
                    if(i==0){
                        if(str[i+1]!=k){ 
                            str[i]=k;
                            break;
                        }
                    }else if(i==str.length-1){
                        if(str[i-1]!=k){ 
                            str[i]=k;
                            break;
                        }
                    }else{
                        if(str[i-1]!=k&&str[i+1]!=k){
                            str[i]=k;
                            break;
                        }
                    }
                }
            }
        }
        return String.valueOf(str);
    }    
}