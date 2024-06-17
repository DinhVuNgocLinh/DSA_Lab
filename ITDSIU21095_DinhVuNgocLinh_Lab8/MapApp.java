import java.util.List;
import java.util.stream.Collectors;

public class MapApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        for (char nodeName = 'A'; nodeName <= 'L'; nodeName++) {
            graph.addNode(String.valueOf(nodeName));
        }
        graph.addNode("2");

        graph.addEdge("A", "B", 6);
        graph.addEdge("B", "D", 14);
        graph.addEdge("D", "K", 15);
        graph.addEdge("A", "2", 10);
        graph.addEdge("2", "B", 12);
        graph.addEdge("B", "C", 11);
        graph.addEdge("D", "E", 4);
        graph.addEdge("D", "H", 6);
        graph.addEdge("H", "K", 12);
        graph.addEdge("2", "C", 12);
        graph.addEdge("C", "E", 6);
        graph.addEdge("E", "H", 12);
        graph.addEdge("2", "F", 8);
        graph.addEdge("C", "F", 3);
        graph.addEdge("F", "H", 16);
        graph.addEdge("2", "G", 16);
        graph.addEdge("F", "I", 6);
        graph.addEdge("I", "H", 13);
        graph.addEdge("H", "L", 18);
        graph.addEdge("K", "J", 9);
        graph.addEdge("G", "I", 8);
        graph.addEdge("I", "L", 17);
        graph.addEdge("J", "L", 20);
        // Print number of paths from A to K
        System.out.println(
                "Number of paths from A to K: " + graph.numberOfPaths(graph.nodes.get("A"), graph.nodes.get("K")));
        // print the smallest and largest number of nodes from A to K and the
        // corresponding cost
        Graph.Result result = graph.findPaths(graph.nodes.get("A"), graph.nodes.get("K"));
        System.out.println("Smallest number of nodes from A to K: " + result.minNodes);
        System.out.println("Largest number of nodes from A to K: " + result.maxNodes);
        System.out.println("Smallest cost from A to K: " + result.minCost);
        System.out.println("Largest cost from A to K: " + result.maxCost);
        // print the shortest path from A to H
        List<Node> path = graph.shortestPath("A", "H");
        System.out.println(
                "Shortest path from A to H: " + path.stream().map(node -> node.id).collect(Collectors.joining(" -> ")));
        // print the shortest path from B to J
        List<Node> path2 = graph.shortestPath("B", "J");
        System.out.println("Shortest path from B to J: "
                + path2.stream().map(node -> node.id).collect(Collectors.joining(" -> ")));
    }
}
