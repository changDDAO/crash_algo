package programmers.lv1;

import java.math.BigInteger;

public class 두수의합 {
    public String solution(String a, String b) {
        String answer = "";
        BigInteger biNum1 = new BigInteger(a);
        BigInteger biNum2 = new BigInteger(b);
        answer = biNum1.add(biNum2).toString();
        return answer;
    }
}
