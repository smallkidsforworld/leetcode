
/**
 * @author ：yml
 * @date ：Created in 2020/10/29 13:26
 * @description：leetcode根节点到叶节点数字之和
 * @modified By：
 */
public class d129 {
    public static int sumNumbers(TreeNode root) {
        return preOrder(root,0);
    }

    public static int preOrder(TreeNode root,int val){
        if(root==null)
            return 0;
        int temp = val * 10 + root.val;
        if(root.left==null&&root.right==null)
            return temp;
        return preOrder(root.left,temp)+preOrder(root.right,temp);
    }

    public static void main(String[] args) {
        System.out.println("sumNumbers(new TreeNode(12)) = " + sumNumbers(new TreeNode(12)));
    }



}
