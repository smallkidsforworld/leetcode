import java.util.LinkedList;
import java.util.Queue;

public class d1609 {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            return false;
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int begin = !flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode top = queue.poll();
                if (top.left != null)
                    queue.add(top.left);
                if (top.right != null)
                    queue.add(top.right);
                if (flag && top.val % 2 == 1 && begin < top.val)
                    begin = top.val;
                else if (!flag && top.val % 2 == 0 && begin > top.val)
                    begin = top.val;
                else
                    return false;
            }
            flag = !flag;
        }
        return true;
    }
        

    public static void main(String[] args) {

    }
}

// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode() {
// }

// TreeNode(int val) {
// this.val = val;
// }

// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }