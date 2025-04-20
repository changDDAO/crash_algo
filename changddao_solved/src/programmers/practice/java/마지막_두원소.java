package programmers.practice.java;

public class 마지막_두원소 {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int n = num_list.length;
        answer = new int[n+1];

        int prev = num_list[n-2];
        int end = num_list[n-1];
        for(int i=0; i<n; i++){
            answer[i] = num_list[i];
        }
        if(prev<end){
            answer[n]=end-prev;
        }else{
            answer[n]=end*2;
        }
        return answer;
    }
}
