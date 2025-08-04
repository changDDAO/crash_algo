package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baek1966 {
    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Queue<Document> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                q.offer(new Document(i, Integer.parseInt(input[i])));
                pq.offer(Integer.parseInt(input[i]));
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                Document curDoc = q.poll();
                if (curDoc.priority == pq.peek()) {
                    cnt++;
                    pq.poll();
                    if (curDoc.index == m) {
                        System.out.println(cnt);
                        break;
                    }
                }else{
                    q.offer(curDoc);
                }
            }

        }



    }
}
