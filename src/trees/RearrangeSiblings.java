package trees;

import structures.TreeNode;
import structures.TreeNodekChildren;

/**
 * Created by xuanwang on 12/19/16.
 */
public class RearrangeSiblings {
    /*
    A tree node has K children, noted as K-way tree. Each child either has a integer value or is NULL.
    Write a function to recursively rearrange this tree so that all the children that are not NULL
    are moved to the left most. All the NULL children are moved to the right.
    The relative sequence of the non-NULL children should stay the same after your function call.
    */

    public static void rearrangeSiblings(TreeNodekChildren root){
        TreeNodekChildren[] children = root.children;
        int p = 0;
        for(int i = 0; i < children.length; i++){
            if(children[i] != null){
                children[p++] = children[i];
            }
        }
        int left = p;
        while(left < children.length){
            children[left++] = null;
        }
        for(int i = 0; i < left; i++){
            rearrangeSiblings(children[i]);
        }
    }
}
