package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class 공백으로_구분하기2 {
    public String[] solution(String my_string) {
        String[] arr = my_string.trim().split(" ");
        List<String> refined = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(!arr[i].equals("")){
                refined.add(arr[i]);
            }
        }
        return refined.stream().toArray(String[]::new);
    }
}
