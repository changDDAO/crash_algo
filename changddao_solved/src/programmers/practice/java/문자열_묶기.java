package programmers.practice.java;

public class 문자열_묶기 {
    public int solution(String[] strArr) {
        int answer = 0;
        int len = 0;
        for(String temp : strArr){
            if(temp.length()>len){
                len = temp.length();
            }
        }
        for(int i = 1; i<=len; i++){
            int cnt = 0;
            for(int j = 0; j<strArr.length; j++){
                if(strArr[j].length()==i){
                    cnt++;
                }
            }
            if(cnt>answer){
                answer=cnt;
            }
        }


        return answer;
    }
}
