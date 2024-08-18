package 프로그래머스;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sco : scoville){
            pq.offer(sco);
        }
        while(pq.peek()<K){
            if(pq.size()==1){
                return -1;
            }
            int least = pq.poll();
            int second = pq.poll();
            int mixed = least+ second*2;
            pq.offer(mixed);
            answer++;
        }

        return answer;
    }
}
