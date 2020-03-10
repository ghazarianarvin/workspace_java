package at.ghazarian.algo;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            depthFirstSearch(array, this);
            return array;
        }

        public void depthFirstSearch(List<String> array, Node root) {
            array.add(root.name);
            for (Node child : root.children) {
                depthFirstSearch(array, child);
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
