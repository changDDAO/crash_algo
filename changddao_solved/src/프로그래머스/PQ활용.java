package 프로그래머스;

import java.util.PriorityQueue;

public class PQ활용 {

        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int sco : scoville){
                pq.offer(sco);
            }
            int cnt = 0;
            while(pq.size()>=2 && pq.peek()<K){
                int first = pq.poll();
                int second = pq.poll();
                int mixed = first + (second * 2);
                pq.add(mixed);
                cnt++;
            }
            if(pq.peek()<K){
                return -1;
            }
            return cnt;
        }

}
