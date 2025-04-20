package programmers.practice.java;

import java.util.ArrayList;
import java.util.List;

public class 배열만들기6 {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        int size = -1;
        for(int i =0; i<arr.length; i++){
            size = answerList.size();
            if(size==0){
                answerList.add(arr[i]);
            }
            else if(size>0 && answerList.get(size-1)==arr[i]){
                answerList.remove(size-1);
            }
            else if(size> 0 && answerList.get(size-1)!=arr[i]){
                answerList.add(arr[i]);
            }
        }
        if(answerList.size()==0){
            return new int[]{-1};
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
