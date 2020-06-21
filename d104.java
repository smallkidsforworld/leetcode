import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class d104{
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        recursive(root,result);
        return result;
    }

    public void recursive(TreeNode root,List<Integer> result){
        if(root!=null){
            result.add(root.val);
            recursive(root.left,result);
            recursive(root.right,result);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}