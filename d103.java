import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class d103 {
    // 广度优先遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag=true;
        queue.add(root);
        while (queue.size()>0) {
            int size = queue.size();
            List<Integer> d= new ArrayList<>();
            for(int i=0;i<size;++i){
                root=queue.remove();
                d.add(root.val);
                if(root.left!=null)
                    queue.add(root.left);
                if(root.right!=null)
                    queue.add(root.right);    
                }
            if(flag)
                Collections.reverse(d);
            flag=!flag;
                result.add(d);
        }
        return result;
    }
}
