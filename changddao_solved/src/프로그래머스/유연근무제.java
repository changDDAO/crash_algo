package 프로그래머스;

public class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        for(int i =0; i<n; i++){
            boolean pass = true;
            int limitTime = addMinutes(schedules[i], 10);
            for(int j = 0; j<7; j++){
                int curDay = (startday -1 + j) % 7 + 1;
                if(curDay == 6 || curDay == 7){
                    continue;
                }
                if(timelogs[i][j]>limitTime){
                    pass = false;
                    break;
                }
            }
            if(pass){
                answer++;
            }
        }
        return answer;
    }
    private int addMinutes(int schedule, int addTime){
        int hour = schedule/100;
        int minute = schedule%100+addTime;

        hour += minute /60;
        minute = minute %60;
        return hour*100 + minute;
    }
}
