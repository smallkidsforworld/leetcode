import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class d95{
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        return generateTrees(0,n);
    }

    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> result = new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;++i){
            // all left set tree
            List<TreeNode> left_result=generateTrees(start,i-1);    
            // all right set tree
            List<TreeNode> right_result=generateTrees(i+1,end);    
            for(TreeNode d_left:left_result){
                for(TreeNode d_right:right_result){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left=d_left;
                    treeNode.right=d_right;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}