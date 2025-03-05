/**
 * Date: 2025/3/2 14:12
 * 94. Binary Tree Inorder Traversal
 */

package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LC94RecursiveApproach {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results = new ArrayList<>();
        inorderTraversal(root, results);
        return results;

    }

    public void inorderTraversal(TreeNode node, List<Integer> results) {

        if(node == null){
            return;
        }

        inorderTraversal(node.left, results);
        results.add(node.val);
        inorderTraversal(node.right, results);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


