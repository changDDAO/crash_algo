package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek2252 {
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] adj;
    static int[] indegree;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        adj = new ArrayList[n + 1];
        indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            adj[a].add(b);
            indegree[b]++;
        }
        topologySort();
        System.out.println(sb);

    }
    static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            Integer prev = q.poll();
            sb.append(prev).append(" ");
            for (int temp : adj[prev]) {
                indegree[temp]--;
                if (indegree[temp] == 0) {
                    q.offer(temp);
                }
            }

        }

    }
}
