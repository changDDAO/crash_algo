package programmers.practice.java;

public class n보다_커질_때까지 {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int value : numbers){
            if(answer<=n)
                answer+=value;
            else break;
        }
        return answer;
    }
}
