package programmers;

import java.util.Arrays;

public class n번째_원소까지 {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        // answer = new int[n];
        // for(int i=0; i<n; i++){
        //     answer[i] = num_list[i];
        //     }
        //다른 풀이
        answer = Arrays.copyOfRange(num_list, 0, n);
        return answer;
    }
}
