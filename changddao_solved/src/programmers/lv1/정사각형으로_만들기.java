package programmers.lv1;

public class 정사각형으로_만들기 {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        int height = arr.length;
        int width = arr[0].length;
        int n = Math.max(height, width);
        answer = new int[n][n];
        for(int i =0; i<height; i++){
            for(int j =0; j<width; j++){
                answer[i][j]=arr[i][j];
            }
        }
        return answer;
    }
}
