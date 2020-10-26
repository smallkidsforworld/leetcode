import java.util.LinkedList;
import java.util.Queue;

public class d117 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            Node first=null;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
                if(first==null)
                    first=temp;
                else{
                    first.next=temp;
                    first=temp;                        
                }
            }
        }
        return root;
    }
}
class Node{
    Node left,right,next;

}