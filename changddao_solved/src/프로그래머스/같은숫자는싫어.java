package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        int [] answer;
        List<Integer> disArr = new ArrayList<>();
        int prevNum = -1;
        for(int i =0; i<arr.length; i++){
            if(prevNum!=arr[i]){
                disArr.add(arr[i]);
            }
            prevNum = arr[i];
        }


        answer = disArr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
