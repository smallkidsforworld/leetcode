package competition.TheTwoHundred;

public class B {
    public int getWinner(int[] arr, int k) {
        int count=0,recode=arr[0];
        for(int i=1;i<arr.length;++i){
            if(recode>arr[i]){
                count++;
                if(count==k)
                    return recode;
            }else{
                recode=arr[i];
                count=1;
                if(count==k)
                    return recode;
            }   
        }
        return recode;
    }
}