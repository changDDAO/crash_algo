package programmers.lv1;

public class 분수의덧셈 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int denom = denom1 * denom2;
        int numer = numer1*denom2 + denom1* numer2;

        int minVal = Math.min(denom, numer);
        System.out.println(minVal);
        int gcd = 1;
        for(int i =2; i<=minVal; i++){
            if(denom % i == 0 && numer % i == 0){
                gcd=i;
            }
        }
        denom /= gcd;
        numer /= gcd;


        int[] answer = new int[]{numer, denom};

        return answer;
    }
}
