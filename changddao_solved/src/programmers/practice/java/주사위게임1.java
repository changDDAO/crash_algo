package programmers.practice.java;

public class 주사위게임1 {
    public int solution(int a, int b) {
        int answer = 0;
        if(a%2==1&& b%2==1){
            answer = (int)(Math.pow(a,2)+Math.pow(b,2));
        }else if(a%2==0 && b%2==0){
            int temp = a-b;
            answer = Math.abs(temp);
        }else{
            answer = 2*(a+b);
        }

        return answer;
    }
}
