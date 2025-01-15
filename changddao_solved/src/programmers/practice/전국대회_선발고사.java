package programmers.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 전국대회_선발고사 {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        List<Integer> rankList = Arrays.stream(rank).boxed().collect(Collectors.toList());
        int [] temp = new int[3];
        int tempIdx = 0;
        int idx = 0;
        for(int i =0; i<rank.length; i++){
            idx = rankList.indexOf(i+1);
            if(attendance[idx] &&tempIdx<3){
                temp[tempIdx] = idx;
                tempIdx++;
            }
        }
        return 10000 *temp[0] + 100*temp[1] + 1*temp[2];
    }
}
