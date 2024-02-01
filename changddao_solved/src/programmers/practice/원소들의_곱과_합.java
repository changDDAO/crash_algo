package programmers.practice;

public class 원소들의_곱과_합 {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 0;
        int mul = 1;
        for(int v: num_list){
            sum+=v;
            mul*=v;
        }
        if(mul>(int)Math.pow(sum,2)){
            answer = 0;
        }else{
            answer = 1;
        }

        return answer;
    }
}
