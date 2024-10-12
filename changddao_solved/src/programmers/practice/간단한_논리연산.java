package programmers.practice;

public class 간단한_논리연산 {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        boolean left = false;
        boolean right = false;
        if(x1 == x2){
            left = x1;
        }else{
            left = true;
        }
        if(x3 == x4){
            right = x3;
        }else{
            right = true;
        }
        if(left==right){
            answer = left;
        }else{
            answer = false;
        }




        return answer;
    }
}
