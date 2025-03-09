package programmers.lv1;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int rollerPos = section[0];
        int cnt = 1;
        for(int i = 1 ; i< section.length; i++){
            //현재 롤러 위치가 구역 값보다 작다면
            if(rollerPos+m-1<section[i]){
                cnt++;
                rollerPos = section[i];
            }
        }
        answer =cnt;
        return answer;
    }
}
