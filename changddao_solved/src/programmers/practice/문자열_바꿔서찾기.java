package programmers.practice;

public class 문자열_바꿔서찾기 {
    public int solution(String myString, String pat) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(pat);
        //AB전환하기
        for(int i = 0; i<sb.length();i++){
            if(sb.charAt(i)=='A'){
                sb.setCharAt(i,'B');
            }else{
                sb.setCharAt(i,'A');
            }
        }
        if(myString.contains(sb.toString())){
            answer = 1;
        }else answer = 0;


        return answer;
    }
}
