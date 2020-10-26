import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class d107{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();     
        if(root==null)
            return result;
        queue.add(root);
        while(queue.size()!=0){
            int size = queue.size();
            List<Integer> single_level = new ArrayList<>();
            for(int i=0;i<size;++i){
                TreeNode now = queue.remove();
                single_level.add(now.val);
                if(now.left!=null)
                    queue.add(now.left);
                if(now.right!=null)
                    queue.add(now.right);
            }
            result.add(single_level);
        }
        Collections.reverse(result);
        return result
    }
}