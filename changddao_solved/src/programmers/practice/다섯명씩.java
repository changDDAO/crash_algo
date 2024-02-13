package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class 다섯명씩 {
    public String[] solution(String[] names) {
        List<String> firstList =  new ArrayList<>();
        for(int i = 0; i<names.length; i+=5){
            firstList.add(names[i]);
        }
        String[] answer = firstList.stream().toArray(String[]::new);
        return answer;
    }
}
