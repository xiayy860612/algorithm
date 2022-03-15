package com.study.algo.datastructure.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Dfs {

    private static class Node {
        public int value;
        public Node[] children;
    }

    private void process(Node node) { }

    public void dfs(Node node, HashSet<Node> visited) {
        process(node);
        visited.add(node);

        for (Node child : node.children) {
            if (visited.contains(child)) {
                continue;
            }
            dfs(child, visited);
        }
    }

    public void dfs2(Node node, HashSet<Node> visited) {
        Deque<Node> stack = new LinkedList<>();
        stack.addLast(node);
        Node cur;
        while (!stack.isEmpty()) {
            cur = stack.removeLast();
            process(cur);
            visited.add(cur);

            reverse(cur.children);
            for (Node child : cur.children) {
                stack.addLast(child);
            }
        }
    }

    private void reverse(Node[] nodes) {
        int l = 0;
        int r = nodes.length - 1;
        while (l < r) {
            Node tmp = nodes[l];
            nodes[l] = nodes[r];
            nodes[r] = tmp;
            ++l;
            --r;
        }
    }
}
