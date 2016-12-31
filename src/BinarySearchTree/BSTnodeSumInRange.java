package BinarySearchTree;

import structures.TreeNode;

/**
 * Created by xuanwang on 12/19/16.
 */
public class BSTnodeSumInRange {

    public int countSum(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > high) {
            return countSum(root.left, low, high);
        } else if (root.val < low) {
            return countSum(root.right, low, high);
        } else {
            return countSum(root.left, low, root.val) + root.val + countSum(root.right, root.val, high);
        }
    }
}
