import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class BSTIterator {
    Stack<Integer> result=new Stack<>();
    public BSTIterator(TreeNode root) {
        midrecursive(root,result);
    }
    

    public void midrecursive(TreeNode root,Stack<Integer> result){
        if(root!=null){
            midrecursive(root.left, result);
            result.add(root.val);
            midrecursive(root.right, result);
        }
    }


    /** @return the next smallest number */
    public int next() {
        return result.pop();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return result.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */