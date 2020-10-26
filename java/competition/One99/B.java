package competition.One99;

public class B {
    public int minFlips(String target) {
        char[] temp = target.toCharArray();
        int res=0;
        while(judge(temp)){
            for(int i=temp.length-1;i>=0;i--){
                if((i>0&&temp[i]=='1'&&temp[i-1]=='0')||(i==0&&temp[i]=='1')){
                    reverseTheArray(temp, i);
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public void reverseTheArray(char[] temp,int index){
        for(int i=index;i<temp.length;++i){
            temp[i]=temp[i]=='0'?'1':'0';
        }
    }

    public boolean judge(char[] temp){
        for(char dd:temp)
            if(dd!='0')
                return false;
        return true;
    }
}