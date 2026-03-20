import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
    private int vertices;
    private List<Integer>[] adjList;

    public BFSTraversal(int v) {
        this.vertices = v;
        adjList = new List[v+1];
        for(int i = 1; i <= v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node+" ");
            for(int n : adjList[node]) {
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BFSTraversal g = new BFSTraversal(8);
        g.addEdge(1,2);
        g.addEdge(1,6);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.bfs(1);
    }
}