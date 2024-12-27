package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class 리스트_자르기 {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        List<Integer> numList = new ArrayList<>();
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        switch(n){
            case 1 :
                for(int i = 0; i<=b; i++){
                    numList.add(num_list[i]);
                }
                break;
            case 2:
                for(int i = a; i<num_list.length; i++){
                    numList.add(num_list[i]);
                }
                break;
            case 3:
                for(int i = a; i<=b; i++){
                    numList.add(num_list[i]);
                }
                break;
            case 4:
                for(int i = a; i<=b; i+=c){
                    numList.add(num_list[i]);
                }
                break;
        }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}
