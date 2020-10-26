public class B{
    public static char findKthBit(int n, int k) {
        return find(k, n,true);
    }


    public static char find(int k,int n,boolean flag){
        int num = 1<<(n-1);
        if(k==1)
            return flag?'0':'1';
        else if(k==num)
            return flag?'1':'0';
        else if(k>num){
            // System.out.println(" k "+k+" num "+num);
            return find(2*num-k, n-1,!flag);
        }else{
            return find(k,n-1,flag);
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(4,11));
        System.out.println(findKthBit(3,1));
        System.out.println(findKthBit(3,5));
    }
}