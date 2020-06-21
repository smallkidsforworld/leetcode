import java.util.Deque;
import java.util.LinkedList;
// 根据先序遍历还原树结构
// 1   先序遍历的顺序：父-左-右
// 2   思路：
//     构造一个栈：根据当前节点的深度找父节点
//         1：将root入栈，此时为栈底，栈大小为1，所以深度为一的节点的父节点是当前栈顶元素。
//         2：将深度为一的节点优先安排在左节点(当左节点不为null，安排在右节点)。将节点入栈。
//         3：当节点深度不与栈大小匹配，此时说明当前栈顶元素不为节点父节点，因此不断出栈，直到匹配为止，不断重复。
class d1028{
    
    public TreeNode recoverFromPreorder(String s){
        Deque<TreeNode> path = new LinkedList<>();
        int pos= 0 ;
        while(pos<s.length()){
            int level=0;
            while(s.charAt(pos)=='-'){
                ++level;
                ++pos;
            }
            int value=0;
            while(pos<s.length()&&Character.isDigit(s.charAt(pos))){
                value = value*10+(s.charAt(pos)-'0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if(level == path.size()){
                if(!path.isEmpty())
                    path.peek().left=node;
            }else{
                while(level!=path.size()){
                    path.pop();
                }
                path.peek().right=node;
            }
            path.push(node);
        }
        while(path.size()>1){
            path.pop();
        }
        return path.peek();
    }
// length  =8
    void create(int[] a,int length){
        TreeNode root = new TreeNode(a[0]);
        TreeNode copy = root;
        int dd = 0;
        while(dd<length){
            
        }
    }

    public static void main(String[] args) {
        String s = "1-2--4-2--4---3";
        int[] result =new d1028().recoverFromPreorder(s);
        for(int i:result){
            System.out.println(i);
        }
    }

}
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int x){ val = x;}
}