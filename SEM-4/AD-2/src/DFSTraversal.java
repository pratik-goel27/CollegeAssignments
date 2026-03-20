import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {
    private int vertices;
    private List<Integer>[] adjList;

    public DFSTraversal(int vertices) {
        this.vertices = vertices;
        adjList = new List[vertices+1];
        for(int i = 1; i <= vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public void startDFS(int start) {
        boolean[] visited = new boolean[vertices+1];
        dfsRecursive(start,visited);
    }

    public void dfsRecursive(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node+" ");
        for(int i : adjList[node]) {
            if(!visited[i]) {
                dfsRecursive(i,visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSTraversal g = new DFSTraversal(6);
        g.addEdge(1,2);
        g.addEdge(2,5);
        g.addEdge(2,6);
        g.addEdge(1,3);
        g.startDFS(1);
    }
}
