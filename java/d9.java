class d9 {

    public boolean charisPalindrome(int x) {
        char[] result = Integer.valueOf(x).toString().toCharArray();
        for(int start=0,end=result.length-1;start<end;start++,end--){
            if(result[start]!=result[end])
                return false;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if(x<0||(x%10==0&&x!=0)
            return false;
        int half =0;
        while(x>half){
            half=half*10+x%10;
            x/=10;
        }
        return x==half||x==half/10;    
    }
    public static void main(String[] args) {
        System.out.println(new d9().isPalindrome(123));
    }
}