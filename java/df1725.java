import java.util.Arrays;

public class df1725{
        public String[] maxRectangle(String[] words) {
            int[] word_length=new int[words.length];
            Arrays.sort(word_length);
            for(int i=0;i<words.length;++i)
                word_length[i]=words[i].length();
            int length=0,area=Integer.MIN_VALUE,num=0,index=0;
            for(int i=0;i<word_length.length-1;++i)
                for(int j=i+1;j<word_length.length-1;++j){
                    if(!judge(i,j,word_length))
                        continue;
                    else{
                        if(area<calculateArea(i, j, word_length)){
                            num=j-i;
                            length=word_length[i];
                            area=calculateArea(i, j, word_length);
                        }
                    }
                }
            String[] result = new String[num];
            for(String d:words){
                if(d.length()==length)
                    result[index++]=d;
            }
            return result;
        }

        public int calculateArea(int start,int end,int[] length){
            return (end-start)*length[start];
        }

        public boolean judge(int start,int end,int[] length){
            for(int i=start;i<end;++i)
                if(length[i]!=length[i+1])
                    return false;
            return true;
        }
}