import java.util.LinkedList;
import java.util.Queue;

import javax.management.QueryEval;

public class d116 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node previous = queue.poll();
                if (i == size - 1) {
                    previous.next = null;
                } else {
                    previous.next = queue.peek();
                }
                if (previous.left != null)
                    queue.add(previous.left);
                if (previous.right != null)
                    queue.add(previous.right);
            }
        }
        return root;
    }
}
