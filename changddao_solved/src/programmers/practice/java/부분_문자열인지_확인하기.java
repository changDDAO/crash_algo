package programmers.practice.java;

public class 부분_문자열인지_확인하기 {
    public int solution(String my_string, String target) {
        int answer = 0;
        if(my_string.contains(target)){
            answer = 1;
        }
        return answer;
    }
}
