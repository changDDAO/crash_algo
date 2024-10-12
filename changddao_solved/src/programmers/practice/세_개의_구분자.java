package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class 세_개의_구분자 {
    public String[] solution(String myStr) {
        String[] answer = {};
        myStr = myStr.replace("a", " ");
        myStr = myStr.replace("b", " ");
        myStr = myStr.replace("c", " ");
        answer = myStr.split(" ");
        List<String> temp = new ArrayList<>();
        for(String piece : answer){
            if(!piece.equals("")){
                temp.add(piece);
            }
        }
        if(temp.size()==0)temp.add("EMPTY");
        answer = temp.toArray(new String[0]);
        return answer;
    }
}
