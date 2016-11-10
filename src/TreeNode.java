import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuanwang on 11/9/16.
 */
public class TreeNode {
    TreeNode left, right;
    int val;
    TreeNode(int val){
        this.val = val;
    }

    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder rst = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode currTree = que.poll();
                if(currTree == null) {
                    rst.append("n ");
                    continue;
                }
                rst.append(currTree.val + " ");
                que.add(currTree.left);
                que.add(currTree.right);
            }
        }
        return rst.toString();
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode currTree = que.poll();
            if (!values[i].equals("n")) {
                currTree.left = new TreeNode(Integer.parseInt(values[i]));
                que.add(currTree.left);
            }
            if (!values[++i].equals("n")) {
                currTree.right = new TreeNode(Integer.parseInt(values[i]));
                que.add(currTree.right);
            }
        }
        return root;
    }
}
