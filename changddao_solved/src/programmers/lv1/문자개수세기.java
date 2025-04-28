package programmers.lv1;

public class 문자개수세기 {
    public int[] solution(String my_string) {
        int[] answer = {};
        //A는 65 , a는 97
        int[] alpha = new int [52];
        for(int i=0; i<my_string.length(); i++){
            char temp = my_string.charAt(i);
            if(temp>='A' && temp<='Z'){
                alpha[temp-'A']++;
            }
            if(temp>='a' && temp<='z'){
                alpha[26+temp-'a']++;
            }
        }

        return alpha;
    }
}
