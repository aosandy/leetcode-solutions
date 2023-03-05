package solutions;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        System.out.println(lowestCommonAncestor(new TreeNode(), new TreeNode(), new TreeNode()));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int x) { this.val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // My first solution
    // Does not take advantage of BST
    // 6 ms
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if ((left == p || left == q) && (right == p || right == q)) {
            return root;
        }
        if (left == p || left == q) {
            return left;
        }
        if (right == p || right == q) {
            return right;
        }
        return left != null ? left : right;
    }

    // Better solution
    // Recursive solution
    // 5 ms
    public static TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor_2(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor_2(root.right, p, q);
        }
        return root;
    }

    // Better solution
    // Iterative solution
    // 5 ms
    public static TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root =  root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
