package programmers.practice.java;

import java.util.ArrayList;
import java.util.List;

public class 배열의_원소_삭제하기 {
    public int[] solution(int[] arr, int[] delete_list) {
        int [] answer = {};
        List<Integer> restList = new ArrayList<>();
        for(int v : arr){
            restList.add(v);
        }
        for(int del : delete_list){
            //지울값이 존재하는 지 List에서 찾기위해서

            int index = restList.indexOf(del);
            if(index!= -1){
                restList.remove(index);
            }
        }
        answer = restList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
