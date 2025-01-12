package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class 무작위로_K개의수_뽑기 {
    public int[] solution(int[] arr, int k) {
        int [] answer = {};
        List<Integer> answerList = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            if(answerList.size()==k){
                break;
            }
            else if(!answerList.contains(arr[i])){
                answerList.add(arr[i]);
            }
        }
        for(int i = answerList.size(); i<k ; i++){
            answerList.add(-1);
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
