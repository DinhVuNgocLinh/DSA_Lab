import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {
    Map<String, Node> nodes = new HashMap<>();

    public void addNode(String id) {
        nodes.put(id, new Node(id));
    }

    public void addEdge(String id1, String id2, int weight) {
        Node node1 = nodes.get(id1);
        Node node2 = nodes.get(id2);
        Edge edge = new Edge(node1, node2, weight);
        node1.edges.add(edge);
        node2.edges.add(edge);
    }

    public int numberOfPaths(Node source, Node destination) {
        Map<Node, Boolean> visited = new HashMap<>();
        for (Node node : nodes.values()) {
            visited.put(node, false);
        }
        return DFS(source, destination, visited);
    }

    public int DFS(Node source, Node destination, Map<Node, Boolean> visited) {
        visited.put(source, true);
        if (source.equals(destination)) {
            visited.put(source, false);
            return 1;
        }
        int paths = 0;
        for (Edge edge : source.edges) {
            Node nextNode = edge.node1.equals(source) ? edge.node2 : edge.node1;
            if (!visited.get(nextNode)) {
                paths += DFS(nextNode, destination, visited);
            }
        }
        visited.put(source, false);
        return paths;
    }

    public class Result {
        int minNodes = Integer.MAX_VALUE;
        int maxNodes = Integer.MIN_VALUE;
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
    }

    public Result findPaths(Node source, Node destination) {
        Map<Node, Boolean> visited = new HashMap<>();
        for (Node node : nodes.values()) {
            visited.put(node, false);
        }
        Result result = new Result();
        DFS(source, destination, visited, 0, 0, result);
        return result;
    }

    public void DFS(Node source, Node destination, Map<Node, Boolean> visited, int numNodes, int cost, Result result) {
        visited.put(source, true);
        numNodes++;
        if (source.equals(destination)) {
            result.minNodes = Math.min(result.minNodes, numNodes);
            result.maxNodes = Math.max(result.maxNodes, numNodes);
            result.minCost = Math.min(result.minCost, cost);
            result.maxCost = Math.max(result.maxCost, cost);
        } else {
            for (Edge edge : source.edges) {
                Node nextNode = edge.node1.equals(source) ? edge.node2 : edge.node1;
                if (!visited.get(nextNode)) {
                    DFS(nextNode, destination, visited, numNodes, cost + edge.weight, result);
                }
            }
        }
        numNodes--;
        visited.put(source, false);
    }

    public class NodeInfo {
        Node node;
        int distance = Integer.MAX_VALUE;
        Node previous = null;

        NodeInfo(Node node) {
            this.node = node;
        }
    }

    public List<Node> shortestPath(String startId, String endId) {
        Map<Node, NodeInfo> nodeInfos = new HashMap<>();
        for (Node node : nodes.values()) {
            nodeInfos.put(node, new NodeInfo(node));
        }

        NodeInfo startInfo = nodeInfos.get(nodes.get(startId));
        startInfo.distance = 0;

        PriorityQueue<NodeInfo> queue = new PriorityQueue<>(Comparator.comparingInt(info -> info.distance));
        queue.add(startInfo);

        while (!queue.isEmpty()) {
            NodeInfo info = queue.poll();
            for (Edge edge : info.node.edges) {
                Node nextNode = edge.node1.equals(info.node) ? edge.node2 : edge.node1;
                NodeInfo nextInfo = nodeInfos.get(nextNode);
                int newDistance = info.distance + edge.weight;
                if (newDistance < nextInfo.distance) {
                    nextInfo.distance = newDistance;
                    nextInfo.previous = info.node;
                    queue.add(nextInfo);
                }
            }
        }

        List<Node> path = new ArrayList<>();
        for (Node node = nodes.get(endId); node != null; node = nodeInfos.get(node).previous) {
            path.add(0, node);
        }
        return path;
    }
}
