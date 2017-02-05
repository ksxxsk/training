package gayle.treegraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<E> {

    private Map<Node<E>, List<Node<E>>> adjacencyLists;

    public Graph() {
        this.adjacencyLists = new HashMap<>();
    }

    public Map<Node<E>, List<Node<E>>> getAdjacencyLists() {
        return adjacencyLists;
    }

    public static class Node<E> {

        private final E value;
        private boolean visited;

        Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }
}
