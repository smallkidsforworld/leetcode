class d8{
	// 字符串转换整数
    // 1：行首去除空格
    // 2：判断首位置符号trim() function
    // 3：判断溢出。
    // if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (int)strlist[start]-'0' > 7)) 
                // return flag==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
    public int myAtoi(String str) {
        if(str.trim().length()<1)
            return 0;
        char[] strlist = str.trim().toCharArray();
        int flag=0,result=0,start=1;
        if(strlist[0]!='-'&&strlist[0]!='+'&&!Character.isDigit(strlist[0]))
            return 0;
        if(strlist[0]=='-')
            flag=1;
        else if(strlist[0]=='+')
            flag=2;
        else{
            flag=3;
            start=0;
        }
        while(start<str.trim().length()&&Character.isDigit(strlist[start])){
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (int)strlist[start]-'0' > 7))
                return flag==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            System.out.println(start+"  start");
                result=result*10+(int)strlist[start]-'0';
            start++;
        }
        return flag==1?result*-1:result;
    }

    public static void main(String[] args) {
        int dd = new d8().myAtoi("2147483646");
        System.out.println(dd);
    }
}
