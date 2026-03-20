import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2 {
    private int vertices;
    int[][] adjMatrix;
    List<Integer>[] adjList;

    public Main2(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices+1][vertices+1];
        adjList = new List[vertices+1];
        for(int i = 0; i <= vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;

        adjList[u].add(v);
        adjList[v].add(u);
    }

    public void displayMatrix() {
        System.out.println("Adjacency Matrix:- ");
        for(int i = 1; i <= vertices; i++) {
            for(int j = 0; j <= vertices; j++) {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void displayList() {
        System.out.println("Adjacency List:- ");
        for(int i = 0; i <= vertices; i++) {
            System.out.print(i+": ");
//            for(int j = 0; j < adjList[i].size(); j++) {
//                System.out.print(adjList[i].get(j)+" ");
//            }
            for(int n : adjList[i]) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void bfs(int start) {
        System.out.println("BFS:- ");
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices+1];
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            int ele = queue.poll();
            System.out.print(ele+" ");
            for(int n : adjList[ele]) {
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    public void startDfs(int start) {
        System.out.println("DFS:- ");
        boolean[] visited = new boolean[vertices+1];
        dfs(start,visited);
    }

    public void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node+" ");
        for(int n : adjList[node]) {
            if(!visited[n]) {
                dfs(n,visited);
            }
        }
    }

    public static void main(String[] args) {
        Main2 g = new Main2(8);
        g.addEdge(1,2);
        g.addEdge(1,6);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(6,7);
        g.addEdge(6,8);
        g.displayMatrix();
        g.displayList();
//        g.bfs(1);
//        g.startDfs(1);
    }
}