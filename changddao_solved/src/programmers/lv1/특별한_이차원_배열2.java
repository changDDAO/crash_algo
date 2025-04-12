package programmers.lv1;

public class 특별한_이차원_배열2 {
    public int solution(int[][] arr) {
        int answer = 1;
        for(int i = 0; i< arr[0].length; i++){
            for(int j =0; j< arr.length; j++){
                if(arr[i][j]!=arr[j][i]){
                    return 0;
                }
            }
        }
        return answer;
    }
}
