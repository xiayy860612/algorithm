package com.study.algo.datastructure.tree;

import java.util.Deque;
import java.util.LinkedList;

public class Bfs {

    private static class Node {
        public int value;
        public Node[] children;
    }

    public void bfs(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node cur = queue.removeFirst();
            process(cur);

            for (Node child : cur.children) {
                queue.addLast(child);
            }
        }
    }

    private void process(Node cur) {

    }
}
