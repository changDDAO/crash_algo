package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1260 {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort((a, b) -> a - b);
        }
        dfs(v);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int vertex) {
        sb.append(vertex).append(" ");
        visited[vertex] = true;
        List<Integer> next = graph.get(vertex);
        for (int i = 0; i < next.size(); i++) {
            if (!visited[next.get(i)]) {
                dfs(next.get(i));
            }
        }
    }

    static void bfs(int vertex) {
        sb.append(vertex).append(" ");
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        visited[vertex] = true;
        while (!q.isEmpty()) {
            Integer vert = q.poll();
            List<Integer> next = graph.get(vert);
            for (int i = 0; i < next.size(); i++) {
                if (!visited[next.get(i)]) {
                    q.offer(next.get(i));
                    sb.append(next.get(i) + " ");
                    visited[next.get(i)] = true;
                }
            }
        }
    }
}
