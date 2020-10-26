import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class d637 {
    public List<Double> averageOfLevels(TreeNode root) {
        //广度优先搜索，记录每一层的value，求和，取平均值，然后add 进入数组
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        if(root==null)
            return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i=0;i<size;++i){
                TreeNode top = queue.poll();
                sum+=top.val;
                if(top.left!=null){
                    queue.add(top.left);
                }
                if(top.right!=null){
                    queue.add(top.right);
                }
            }
            list.add(sum/size);
        }
        return list;
    }
}