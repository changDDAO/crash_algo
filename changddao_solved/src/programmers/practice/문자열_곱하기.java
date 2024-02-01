package programmers.practice;

public class 문자열_곱하기 {
    public String solution(String my_string, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append(my_string);
        }
        answer = sb.toString();
        return answer;
    }
}
