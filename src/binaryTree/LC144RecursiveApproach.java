/**
 * Date: 2025/3/2 13:57
 * 144. Binary Tree Preorder Traversal
 */

package binaryTree;


import java.util.ArrayList;
import java.util.List;

public class LC144RecursiveApproach {


    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> results = new ArrayList<>();
            preorderTraversal(root, results);
            return results;
        }

        public void preorderTraversal(TreeNode root, List<Integer> results){
            if(root == null){
                return;
            }

            results.add(root.val);
            preorderTraversal(root.left, results);
            preorderTraversal(root.right, results);
        }


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
