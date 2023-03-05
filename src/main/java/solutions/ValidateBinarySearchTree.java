package solutions;

import java.util.*;

/**
 * 98. Validate Binary Search Tree
 */

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(isValidBST_2(new TreeNode()));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Gigachad solution
    public static boolean isValidBST_2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        long prevN = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (node.val <= prevN) {
                return false;
            }
            prevN = node.val;
            root = node.right;
        }
        return true;
    }

    // Naive solution
    public static boolean isValidBST(TreeNode root) {
        boolean res = true;
        if (root.left != null) {
            res = subtreeMax(root.left) < root.val && isValidBST(root.left);
        }
        if (root.right != null) {
            res = res && subtreeMin(root.right) > root.val && isValidBST(root.right);
        }
        return res;
    }

    private static int subtreeMin(TreeNode node) {
        int min = node.val;
        if (node.left != null) {
            int newMin = subtreeMin(node.left);
            if (newMin < min) {
                min = newMin;
            }
        }
        if (node.right != null) {
            int newMin = subtreeMin(node.right);
            if (newMin < min) {
                min = newMin;
            }
        }
        return min;
    }

    private static int subtreeMax(TreeNode node) {
        int max = node.val;
        if (node.left != null) {
            int newMax = subtreeMax(node.left);
            if (newMax > max) {
                max = newMax;
            }
        }
        if (node.right != null) {
            int newMax = subtreeMax(node.right);
            if (newMax > max) {
                max = newMax;
            }
        }
        return max;
    }
}
