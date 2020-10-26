import java.util.ArrayList;
import java.util.List;

public class d99 {
    List<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        TreeNode value_one=null,value_two=null;
        midOrder(root);
        for(int i=0;i<list.size()-1;++i){
            if(list.get(i).val>list.get(i+1).val)
                if(value_one==null)
                    value_one=list.get(i);
                else{
                    value_two=list.get(i+1);
                    break;
                }
        }
        if(value_two==null)
            value_two=list.get(list.indexOf(value_one)+1);
        int temp = value_one.val;
        value_one.val=value_two.val;
        value_two.val=temp;
    }

    public void midOrder(TreeNode root){
        if(root==null)
            return;
        midOrder(root.left);
        list.add(root);
        midOrder(root.right);
    }
}
