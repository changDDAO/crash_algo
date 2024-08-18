package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek13023 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n, m;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            findFriend(i, 0);
            visited[i]= false;
            if (answer == 1) break;
        }
        System.out.println(answer);
    }
    static void findFriend(int node, int depth) {
        if (depth == 4) {
            answer = 1 ;
            return;
        }
        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                visited[nextNode]= true;
                findFriend(nextNode, depth+1);
                visited[nextNode]=false;
            }
        }
    }


}
