import java.util.ArrayList;
import java.util.List;

public class d1291 {
    List<List<Integer>> list;
    {
        list = new ArrayList<>();
        for(int i=1;i<10;++i){
            list.add(createTheList(i));
        }
    }

    public List<Integer> sequentialDigits(int low, int high) {
        if(high>123456789)
            high=123456799;
        List<Integer> result=new ArrayList<Integer>();
        for(int i=getLength(low)-1;i<=getLength(high)-1;++i){
            List<Integer> current_index = list.get(i);

            for(int num:current_index){
                if(num>low&&num<high){
                    result.add(num);
                }
            }
        }
        return result;
    }

    public static int getLength(int low){
        return String.valueOf(low).length();
    }

    public static List<Integer> createTheList(int length){
        List<Integer> result= new ArrayList<>();
        for(int i = 1;i<11-length;++i){
            StringBuilder create_str = new StringBuilder();
            for(int j=i;j<i+length;++j){
                create_str.append(j);                
            }
            result.add(Integer.valueOf(create_str.toString()));
        }
        return result;
    }

    public static void main(String[] args) {
        d1291 dd = new d1291();
        List<Integer> temp = dd.sequentialDigits(100,300);
        for(int i:temp){
            System.out.println(i);
        }
    }
}