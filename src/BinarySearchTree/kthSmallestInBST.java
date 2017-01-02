package BinarySearchTree;

import structures.TreeNode;

import java.util.LinkedList;

/**
 * Created by xuanwang on 12/31/16.
 */
public class kthSmallestInBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public int kthSmallest(TreeNode root, int k) {
        int i = 0;
        TreeNode p = root;
        LinkedList<TreeNode> s = new LinkedList<>();
        while(p != null || ! s.isEmpty()){
            while(p != null){
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            if(++i == k){
                return p.val;
            }
            p = p.right;
        }
        return 0;
    }

}
