package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 */

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        System.out.println(levelOrder_2(new TreeNode()));
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

    // 6 ms
    public static List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<TreeNode> current;
        List<TreeNode> next = new LinkedList<>();
        if (root != null) {
            res.add(new LinkedList<>(List.of(root.val)));
            next.add(root.left);
            next.add(root.right);
        }
        while (next.remove(null));
        while (!next.isEmpty()) {
            res.add(new LinkedList<>(next.stream().map(x -> x.val).toList()));
            current = new LinkedList<>(next);
            next.clear();
            while (!current.isEmpty()) {
                TreeNode node = current.get(0);
                next.add(node.left);
                next.add(node.right);
                current.remove(0);
            }
            while (next.remove(null));
        }
        return res;
    }

    // 1 ms
    public static List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>(List.of(root));
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
