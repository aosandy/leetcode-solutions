package solutions;

import java.util.*;

/**
 * 589. N-ary Tree Preorder Traversal
 */

public class N_aryTreePreorderTraversal {
    public static void main(String[] args) {
        System.out.println(preorder(new Node()));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return new LinkedList<>();
        }
        res.add(root.val);
        for (Node node : root.children) {
            res.addAll(preorder(node));
        }
        return res;
    }

    static class Stack {
        Node[] arr;
        int p;

        public Stack(int size) {
            arr = new Node[size];
        }

        public void put(Node x) {
            arr[p++] = x;
        }

        public Node pop() {
            if (p > 0) {
                return arr[--p];
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean isEmpty() {
            return p == 0;
        }
    }

    public static List<Integer> preorder_2(Node root) {
        List<Integer> res = new LinkedList<>();
        Stack stack = new Stack(1000);
        stack.put(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node == null) {
                continue;
            }
            res.add(node.val);
            Collections.reverse(node.children);
            for (Node curr : node.children) {
                stack.put(curr);
            }
        }
        return res;
    }
}
