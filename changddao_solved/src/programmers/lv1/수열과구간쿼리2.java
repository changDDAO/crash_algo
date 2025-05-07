package programmers.lv1;

public class 수열과구간쿼리2 {
    class Solution {
        public int[] solution(int[] arr, int[][] queries) {
            int[] answer = new int[queries.length];
            for(int i =0; i<queries.length; i++){
                int [] query = queries[i];
                int start = query[0];
                int end = query[1];
                int target = query[2];
                int matchNum = Integer.MAX_VALUE;
                for(int j = start; j<=end; j++){
                    if(arr[j]>target && arr[j]<matchNum){
                        matchNum=arr[j];
                    }
                }
                if(matchNum==Integer.MAX_VALUE){
                    matchNum= -1;
                }
                answer[i]=matchNum;
            }
            return answer;
        }
    }
}
