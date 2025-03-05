/**
 * Date: 2025/3/5 09:18
 */

package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC144IterativeApproach {

    public List<Integer>  preorderTraversal(TreeNode root){

        // create a list to store the traversal order
        List<Integer> results = new LinkedList<>();

        if(root == null) return results;

        // create a stack to simulate the recursion
        Stack<TreeNode> stack = new Stack<>();

        // start with pushing the root node onto the stack
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current =stack.pop(); // pop the top node
            results.add(current.val); // store the top node value in the list

            if(current.right!=null){ // push the right child
                stack.push(current.right);
            }
            if(current.left!=null){ // push the left child
                stack.push(current.left);
            }
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
