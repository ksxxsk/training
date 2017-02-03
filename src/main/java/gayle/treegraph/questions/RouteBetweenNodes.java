package gayle.treegraph.questions;

import gayle.treegraph.Graph;

import java.util.*;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes. Hints: #127
 */
public class RouteBetweenNodes {

    public boolean rootBetweenTwoNodesBFS(Graph graph, Graph.Node node1, Graph.Node node2) {

        Map<Graph.Node, List<Graph.Node>> adjacencyLists = graph.getAdjacencyLists();

        Queue<Graph.Node> queue = new LinkedList<>();
        node1.setVisited(true);

        while (!queue.isEmpty()) {
            Graph.Node parent = queue.remove();
            for (Graph.Node node : adjacencyLists.get(parent)) {
                if(node == node2)
                    return true;

                if (!node.isVisited()) {
                    node.setVisited(true);
                    queue.add(node);
                }
            }
        }

        return false;
    }

    public boolean rootBetweenTwoNodesDFS(Graph graph, Graph.Node node1, Graph.Node node2) {

        Map<Graph.Node, List<Graph.Node>> adjacencyLists = graph.getAdjacencyLists();

        Deque<Graph.Node> stack = new LinkedList<>();
        stack.push(node1);

        while (!stack.isEmpty()) {
            Graph.Node n = stack.pop();
            if(!n.isVisited()) {
                n.setVisited(true);
                for(Graph.Node adjanced: adjacencyLists.get(n)) {
                    if(adjanced == node2)
                        return true;
                    stack.push(adjanced);
                }
            }
        }

        return false;
    }
}
