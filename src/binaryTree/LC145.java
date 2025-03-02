/**
 * Date: 2025/3/2 14:22
 * 145. Binary Tree Postorder Traversal
 */

package binaryTree;
import java.util.ArrayList;
import java.util.List;

public class LC145 {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> results = new ArrayList<>();
        postorderTraversal(root, results);
        return results;

    }

    public void postorderTraversal(TreeNode node, List<Integer> results) {

        if(node == null){
            return;
        }

        postorderTraversal(node.left, results);
        postorderTraversal(node.right, results);
        results.add(node.val);
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
