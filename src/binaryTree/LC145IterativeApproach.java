/**
 * Author: Bintong
 * Date: 2025/3/5 09:55
 */

package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC145IterativeApproach {

    // Alternative approach for postorder traversal:
    // 1. Use the same logic as LC144IterativeApproach, but process the RIGHT child before the LEFT child.
    // 2. This will give nodes in the order: root → right → left.
    // 3. Reverse the result at the end to get postorder traversal: left → right → root.

    // approach using two stacks
    public List<Integer> postorderTraversal(TreeNode root){

        List<Integer> results = new ArrayList<>();

        if(root == null) return results;

        Stack<TreeNode> stack1 = new Stack<>(); // for processing the node
        Stack<TreeNode> stack2 = new Stack<>(); // for storing the nodes in reserve order

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode current = stack1.pop();
            stack2.push(current);

            if(current.left!= null){
                stack1.push(current.left);
            }

            if(current.right!= null){
                stack1.push(current.right);
            }
        }

        while(!stack2.isEmpty()){
            results.add(stack2.pop().val);
        }
        return results;
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
