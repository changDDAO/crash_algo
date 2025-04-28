package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class 배열만들기4 {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        for(int i=0; i<arr.length;){
            if(stk.size()<=0){
                stk.add(arr[i]);
                i++;
            }else{
                if(stk.get(stk.size()-1)<arr[i]){
                    stk.add(arr[i]);
                    i++;
                }else{
                    stk.remove(stk.size()-1);
                }
            }
        }
        return stk.stream().mapToInt(e -> e).toArray();

    }
}
