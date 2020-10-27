import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.tree.TreeNode;

public class d144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        return result;
    }
    public void preorder(List<Integer> result,TreeNode root){
        if(root==null)
            return;
        result.add(root.val);
        preorder(result,root.left);
        preorder(result,root.right);
    }

}