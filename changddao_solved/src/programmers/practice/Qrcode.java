package programmers.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Qrcode {
    public String solution(int q, int r, String code) {
        String answer = "";
        List<String> strList = new ArrayList<>();
        for(int i =0; i<code.length(); i++){
            if(i%q==r){
                strList.add(String.valueOf(code.charAt(i)));
            }
        }
        answer = String.join("", strList);

        return answer;
    }
}
