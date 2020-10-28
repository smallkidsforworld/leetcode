package java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

import jdk.nashorn.internal.ir.Flags;

public class d635 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        preOrder(root, set);
        for (Integer i : set)
            if (k - i != i && set.contains(k - i))
                return true;
        return false;

    }

    public void preOrder(TreeNode root, Set<Integer> set) {
        if (root == null)
            return;
        preOrder(root.left, set);
        set.add(root.val);
        preOrder(root.right, set);
    }

}