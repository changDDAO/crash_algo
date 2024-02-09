package programmers.practice;

public class 홀짝에_따라_다른_값_반환하기 {
    public int solution(int n) {
        int answer = 0;
        //짝수라면
        if(n %2 == 0){
            for(int i =2; i<=n; i+=2){
                answer+= (int)Math.pow(i,2);
            }
        }
        else{
            for(int i =1; i<=n; i+=2){
                answer+= i;
            }
        }
        return answer;
    }
}
