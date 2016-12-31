/**
 * Created by xuanwang on 11/9/16.
 */
public class RemoveZeroSubtree {
    public static int removeZeroSubtree(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return root.val;
        }

        int left = removeZeroSubtree(root.left);
        int right = removeZeroSubtree(root.right);
        int sum = left + right + root.val;
        if(left == 0){
            root.left = null;
        }
        if(right == 0){
            root.right = null;
        }
        return sum;
    }

    public static void main(String[] args){
        TreeNode src = TreeNode.deserialize("1 2 3 -1 -1 0 -3");
        removeZeroSubtree(src);
        String str = TreeNode.serialize(src);
        System.out.println("NOP");
    }
}
