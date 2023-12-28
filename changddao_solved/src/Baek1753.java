import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1753 {
    static int dist[];
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        dist = new int[v + 1];
        //graph 초기화 해주기
        for (int i = 0; i <= v; i++) { // 0인덱스는 사용 X Node num과 맞춰주기 위함
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
        }
        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    //최단 경로 문제
    static void dijkstra(int start){
        dist[start] = 0; // 시작점은 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            List<Node> children = graph.get(curNode.num);
            for(Node child: children){
                if(dist[child.num]> curNode.weight+child.weight){
                    dist[child.num] = curNode.weight + child.weight;
                    pq.offer(new Node(child.num, dist[child.num]));
                }
            }
        }



    }
    static class Node implements Comparable<Node>{
        private int num;
        private int weight;

        public Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
