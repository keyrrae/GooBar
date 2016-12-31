package binaryTrees;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xuanwang on 12/19/16.
 */
public class ShouldRemove {

    /*给你一棵树的root节点，还有一个函数boolean shouldRemove(Node node) 返回是否需要删除这个节点。
    要求输出一个list<Node>，list是删除所有节点后原来的树分裂成的子树的集合。*/

    public static List<TreeNode> remove(TreeNode root) {
        List<TreeNode> result=new ArrayList<>();
        helper(null,root,result);
        return result;
    }

    public static void helper(TreeNode parent,TreeNode cur,List<TreeNode> result) {
        if(cur==null) return;
        if(shouldRemove(cur)) {
            if(parent != null) {
                if(parent.left==cur) parent.left=null;
                else parent.right=null;
            }
            helper(null, cur.left, result);
            helper(null, cur.right, result);
        } else {
            if(parent == null) result.add(cur);
            helper(cur, cur.left, result);
            helper(cur, cur.right, result);
        }
    }

    public static boolean shouldRemove(TreeNode cur){
        Random rnd = new Random();

        return rnd.nextBoolean();
    }
}
