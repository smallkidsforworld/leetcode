package competition;

public class binarySearchInTwoDimion {
    public boolean Find(int target, int [][] array) {
        int length=array.length;
        int size_row = array[0].length;
        int i=length-1,j=0;
        while(i>=0&&j<size_row){
            if(target<array[i][j]){
                i--;
            }else if(target>array[i][j]){
                j++;
            }
            else return true;
        }
        return false;
    }
    


    public static void main(String[] args) {
    }
}