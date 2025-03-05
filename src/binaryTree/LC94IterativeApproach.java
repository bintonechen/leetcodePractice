/**
 * Author: Bintong
 * Date: 2025/3/5 11:07
 */

package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94IterativeApproach {

    public List<Integer> inorderTraversal(TreeNode root){

        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while(current!=null || !stack.isEmpty()){
            if(current !=null){
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current= current.right;
            }
        }
        return result;

    }


    public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
