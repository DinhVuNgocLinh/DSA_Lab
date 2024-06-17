import java.util.ArrayList;
import java.util.List;

public class Node {
    String id;
    List<Edge> edges = new ArrayList<>();

    public Node(String id) {
        this.id = id;
    }
}