package programmers.practice;

import java.util.Arrays;

public class 배열_비교하기 {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int leftLen = arr1.length;
        int rightLen = arr2.length;
        if(leftLen>rightLen){
            answer= 1;
        }else if(rightLen>leftLen){
            answer=-1;
        }
        else{// len이 같다면
            //원소합 비교하기
            int leftValue = Arrays.stream(arr1).sum();
            int rightValue = Arrays.stream(arr2).sum();
            if(leftValue>rightValue){
                answer = 1;
            }else if(rightValue>leftValue){
                answer=-1;
            }
            else{answer = 0;}
        }
        return answer;
    }
}
