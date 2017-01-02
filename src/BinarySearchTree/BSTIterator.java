package BinarySearchTree;

import structures.TreeNode;

import java.util.LinkedList;

/**
 * Created by xuanwang on 1/1/17.
 */
public class BSTIterator {
    LinkedList<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new LinkedList<>();
        TreeNode p = root;
        while(p!= null){
            s.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = s.pop();
        int ans = p.val;
        p = p.right;
        while(p != null){
            s.push(p);
            p = p.left;
        }
        return ans;
    }
}
