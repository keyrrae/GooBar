package LinkedList;

import structures.TreeNode;

/**
 * Created by xuanwang on 12/31/16.
 */
public class PlusOneLinkedList {
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }
            root = root.val > target? root.left: root.right;
        }
        return ret;
    }
}
