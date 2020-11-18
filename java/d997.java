public class d997 {
    public static int findJudge(int N, int[][] trust) {
        int[] n = new int[N+1];
        for (int i = 0; i < trust.length; ++i) {
            n[trust[i][1]]++;
            n[trust[i][0]]--;
        }
        for(int i:n)
            System.out.print(i+" ");
        for (int i=0;i<n.length;++i)
            if(n[i]==N-1)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = {{1,2}};
        System.out.println(findJudge(2,trust));   
    }
}