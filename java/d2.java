class d2{

    public int getDnumber(int[] A,int[] B,int k){
        int a_start=0,b_start=0;
        while(true){
            if(a_start==A.length)
                return B[b_start+k-1];
            if(b_start==B.length)
                return A[a_start+k-1];
            if(k==1)
                return Math.min(A[a_start], B[b_start]);
            
            int half =k/2;
            int new_a_start=Math.min(a_start+half, A.length)-1;
            int new_b_start=Math.min(b_start+half, B.length)-1;
            int pivot_a = A[new_a_start],pivot_b=B[new_b_start];
            if(pivot_a<pivot_b){
                a_start=new_a_start+1;
                k-=new_a_start-a_start+1;
            }else{
                k-=new_b_start-b_start+1;
                b_start=new_b_start+1;
            }
        }    
        return 0;
    }

    //asume the A the long array
    public double midnum(int[] A,int[] B){
        if((A.length+B.length)%2!=0)
            return getDnumber(A, B, (A.length+B.length)/2);
        else{
            return (getDnumber(A, B, (A.length+B.length)/2-1)+getDnumber(A, B, (A.length+B.length)/2))*0.5;
        }
    }

    public static void main(String[] args) {

    }
}