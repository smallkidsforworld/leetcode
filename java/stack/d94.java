package stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class d94{
// 中序遍历：
//     左 根 右
// 先序遍历
//     根 左 右
// 后序遍历
//     左 右 根


    // 迭代写法
    public List<Integer> Iterate(TreeNode root,List<Integer> results){
        Stack<TreeNode> result=new Stack<>();
        while(result.size()!=0||root!=null){
            while(root!=null){
                result.push(root);
                root=root.left;
            }
            root=result.pop();
            results.add(root.val);
            root=root.right;
        }
        return results;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Iterate(root, result);
        return result;
    }
    
    // 递归写法
    public void Recursive(TreeNode root,List<Integer> result){
        if(root!=null){
            Recursive(root.left, result);
            result.add(root.val);
            Recursive(root.right, result); 
        }
    }

}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
