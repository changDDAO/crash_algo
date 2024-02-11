package programmers.practice;

public class A강조하기 {
    public String solution(String myString) {
        String answer = "";
        StringBuilder sb = new StringBuilder(myString);
        for(int i=0; i<sb.length();i++){
            if(sb.charAt(i)=='a'||sb.charAt(i)=='A'){
                sb.setCharAt(i,'A');
            }else{
                sb.setCharAt(i,Character.toLowerCase(sb.charAt(i)));
            }
        }
        return sb.toString();
    }
}
