package programmers.practice.java;

public class 수열과_구간쿼리_3 {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i<queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        return arr;
    }
}
