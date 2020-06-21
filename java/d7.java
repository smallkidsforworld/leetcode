class d7{
    // 整数反转：
    // 使用long类型数据进行记录，最终(int)long==long判断是否溢出
    public int reverse(int x) {
        long finalresult=0;
        while(x!=0){
            finalresult=finalresult*10+x%10;
            x=x/10;
        }
        return (int)finalresult==finalresult?(int)finalresult:0;
    }

    public static void main(String[] args) {
        System.out.println(new d7().reverse(1534236469));
        System.out.println(Integer.MAX_VALUE);
    }
}