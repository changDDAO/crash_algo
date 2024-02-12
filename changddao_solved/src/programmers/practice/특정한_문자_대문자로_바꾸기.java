package programmers.practice;

public class 특정한_문자_대문자로_바꾸기 {
    public String solution(String my_string, String alp) {
        String answer = "";
        char [] myArr =  my_string.toCharArray();
        for(int i = 0; i<myArr.length; i++){
            if(myArr[i]==alp.charAt(0)){
                myArr[i] = Character.toUpperCase(alp.charAt(0));
            }
        }
        answer = String.valueOf(myArr);
        return answer;
    }
}
