package programmers.practice;

public class 수열과_구간쿼리1 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            for(int j=start; j<=end; j++){
                answer[j]= answer[j]+1;
            }
        }

        return answer;

    }
}
