package 프로그래머스;

public class 문자열의_뒤의_n글자 {
    class Solution {
        public String solution(String my_string, int n) {
            String answer = my_string;
            answer = answer.substring(answer.length()-n);
            return answer;
        }
    }
}
