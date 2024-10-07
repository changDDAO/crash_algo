package programmers.practice;

public class 문자열_뒤집기 {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sbL = new StringBuilder();
        StringBuilder sbM = new StringBuilder();
        StringBuilder sbR = new StringBuilder();
        for(int i = 0; i<s; i++){
            sbL.append(my_string.charAt(i));
        }
        for(int i = s; i<=e ; i++){
            sbM.append(my_string.charAt(i));
        }
        for(int i = e+1; i<my_string.length(); i++){
            sbR.append(my_string.charAt(i));
        }
        sbM.reverse();
        sb.append(sbL).append(sbM).append(sbR);

        return sb.toString();
    }
}
