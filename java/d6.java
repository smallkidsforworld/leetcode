
class d6{
    // Z字形输入
    // 方法1：建立一个String数组，分别按位置读取每一行，加入到对应的String中
    // 方法2：利用索引，顺序按照每一行的进行获取元素。首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
    // 利用索引角标的规律，即：
    // 第0行 k为列数，K*(nums*2-2)
    // 最后一行，K*(nums*2-2)+nums-1
    public String convert(String s, int numRows) {
        if(numRows==1||s.length()<=2)
            return s;
        String[] resultlist = new String[numRows];        
        for(int i=0;i<resultlist.length;++i)
            resultlist[i]="";
        boolean flag=true;
        int location=0;
        for(int i=0;i<s.length();++i){
            resultlist[location]+=s.charAt(i);
            location=flag?location+1:location-1;
            if(location==numRows-1) flag=false;
            if(location==0) flag=true;
        }
        String result="";
        for(String sd:resultlist)
            result+=sd;
        return result;
    }

    public static void main(String[] args) {
        String s = new d6().convert("LEETCODEISHIRING", 4);
        System.out.println(s);
    }


}