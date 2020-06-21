class d125{
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        char[] charset = s.toCharArray();
        while(left<right){
            if(!Character.isLetterOrDigit(charset[left])){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(charset[right])){
                right--;
                continue;
            }
            if(Character.toLowerCase(charset[left])==Character.toLowerCase(charset[right])){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="race a car";
        System.out.println(new d125().isPalindrome(s));
    }

}