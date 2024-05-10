package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphDS {

    // Adjacency List Representation of an Undirected Graph

    private LinkedList<Integer>[] adj;
    private int V; // V is number of vertices
    private int E; // E is number of edges

    public GraphDS(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for(int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v : adj[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }

    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while(!stack.isEmpty()) {
            int u = stack.pop();
            if(!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");

                for(int v : adj[u]) {
                    if(!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        GraphDS g = new GraphDS(5);
        g.addEdge(0, 1); // edge from vertex 0 -> 1
        g.addEdge(1, 2); // 1 -> 2
        g.addEdge(2, 3); // 2 -> 3
        g.addEdge(3, 0); // 3 -> 0
        g.addEdge(2, 4);
        g.bfs(0);
        g.dfs(0);
        System.out.println();
        System.out.println(g);

    }

}

