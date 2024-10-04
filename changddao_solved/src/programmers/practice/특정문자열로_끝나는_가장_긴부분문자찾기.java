package programmers.practice;

public class 특정문자열로_끝나는_가장_긴부분문자찾기 {
    public String solution(String myString, String pat) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int splIdx = myString.lastIndexOf(pat);
        String tmp1 = myString.substring(0,splIdx);
        String tmp2 = myString.substring(splIdx,splIdx+pat.length());
        sb.append(tmp1).append(tmp2);
        answer =sb.toString();
        return answer;
    }
}
