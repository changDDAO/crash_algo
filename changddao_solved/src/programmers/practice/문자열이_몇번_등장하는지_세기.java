package programmers.practice;

public class 문자열이_몇번_등장하는지_세기 {
    public int solution(String myString, String pat) {
        int cnt = 0;
        for(int i=0; i<myString.length(); i++) {
            if(myString.substring(i).startsWith(pat)){
                cnt++;
            }
        }
        return cnt;
    }
    public int solution2(String myString, String pat) {
        int answer = 0;
        for(int i = myString.length()-1; i>=0; i--){
            String sub = myString.substring(0, i+1);
            if(sub.endsWith(pat)){
                answer++;
            }
        }
        return answer;
    }

}
