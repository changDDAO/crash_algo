package programmers.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        //최종적인 목표는 요청부터 종료까지 걸린시간의 평균이 가장 작게
        int answer = 0;
        //일단 도착시간을 기준으로 오름차순 정렬하기
        Arrays.sort(jobs, (jobA, jobB)->jobA[0]-jobB[0]);
        //작업시간이 짧은 순으로, 정렬하기
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);

        int jobCnt = 0;
        int jobIdx = 0;
        int end = 0; //이전 작업의 종료시간
        while(jobCnt<jobs.length){
            while(jobIdx<jobs.length && jobs[jobIdx][0]<=end){
                pq.offer(jobs[jobIdx++]);
            }
            if(pq.isEmpty()){// end를 다음 요청의 가장 처음으로
                end = jobs[jobIdx][0];
            }else{
                int [] task = pq.poll();
                int requestTime = task[0];
                int taskTime = task[1];
                answer+=taskTime+end-requestTime;
                end+=taskTime;
                jobCnt++;
            }
        }


        return answer/jobs.length;
    }
}
