public class f0105{
    public boolean oneEditAway(String first, String second) {
        if(first.equals(second))
            return true;
        if(first.length()-second.length()>1)
            return false;
        for(int i=0,j=0;i<first.length()&&j<second.length();++i,++j){
            if(first.charAt(i)!=second.charAt(j)){
                return operator(first,second,i,j);
            }
        }
        return true;
    }

    public boolean operator(String first,String second,int i,int j){
        boolean flag=false;
        if(first.length()>second.length()){
            flag=first.substring(i+1).equals(second.substring(j));
        }else{
            flag=first.substring(i).equals(second.substring(j+1));
        }
        return flag||first.substring(i+1).equals(second.substring(j+1));
    }
}