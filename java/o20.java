    public class o20{
        public boolean isNumber(String s) {
            char[] char_arr = s.toCharArray();
            // found + , at the first place or after e
            for(int i=0;i<char_arr.length;++i){
                int e_time=0;
                boolean flag=false;
                switch(char_arr[i]){
                    case '-':
                        if(i==0||char_arr[i-1]=='e'||char_arr[i-1]=='E')
                            break;
                        else
                            return false;
                    case '+':
                        if(i==0)
                            break;
                        else
                            return false;
                    case 'E':
                        if(e_time!=0)
                            return false;
                        e_time=1;
                        flag=true;
                        break;
                    case '.':
                        if(flag=true)
                            return false;
                        break;
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9': break;
                }
            }
            return true;
        }
}