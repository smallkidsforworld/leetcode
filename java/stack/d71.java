import java.util.Stack;
import java.util.Vector;

// package stack;
public class d71{
    public String simplifyPath(String path) {
        String[] dd = path.trim().split("/");
        Stack<String> pathstore = new Stack<>();
        for(int i=0;i<dd.length;++i){
            if(dd[i].length()<1||dd[i].equals("."))
                continue;
            if(dd[i].equals("..")){
                if(!pathstore.isEmpty())
                    pathstore.pop();
                continue;
            }
            System.out.println(dd[i]+" i = "+i);
            pathstore.push(dd[i]);
        }
        String result="";
        while(!pathstore.isEmpty()){
            result="/"+pathstore.peek()+result;
            pathstore.pop();
        }
        if(result.length()==0)
            return "/";
        return result;
    }


    public static void main(String[] args) {
        String path="/home//foo/";
        String[] dd = path.trim().split("/");
        for(int i=0;i<dd.length;++i){
            System.out.print(i+" ="+dd[i].length()+"length ");
            System.out.println(dd[i]);
        }
        System.out.println(new d71().simplifyPath(path));

    }

}
