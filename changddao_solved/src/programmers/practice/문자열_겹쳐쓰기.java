package programmers.practice;

public class 문자열_겹쳐쓰기 {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char [] srcArray = my_string.toCharArray();
        int overIdx = 0;
        for(int i = s; i<s+overwrite_string.length(); i++){
            srcArray[i] = overwrite_string.charAt(overIdx++);
        }
        answer = new String(srcArray);
        return answer;
    }
}
