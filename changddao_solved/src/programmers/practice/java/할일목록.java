package programmers.practice.java;

import java.util.ArrayList;
import java.util.List;

public class 할일목록 {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> doList = new ArrayList<>();
        for(int i =0; i<finished.length; i++){
            if(!finished[i]){
                doList.add(todo_list[i]);
            }
        }
        String[] answer = doList.stream().toArray(String[]::new);
        return answer;
    }
}
