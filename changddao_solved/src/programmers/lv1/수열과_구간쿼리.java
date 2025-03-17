package programmers.lv1;

public class 수열과_구간쿼리 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        for (int [] query : queries){
            int start = query[0];
            int end = query[1];
            int k = query[2];
            for(int i =start; i<=end; i++){
                if(i%k ==0){
                    arr[i]++;
                }
            }
        }
        answer = arr;
        return answer;
    }
}
