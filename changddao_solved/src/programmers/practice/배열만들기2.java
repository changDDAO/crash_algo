package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class 배열만들기2 {
    public int[] solution(int l, int r) {
        int[] answer = {};
        List<Integer> numList = new ArrayList<>();
        for(int i=l ; i<=r ; i++){
            String temp = String.valueOf(i);
            String [] list = temp.split("");
            int len = list.length;
            int cnt = 0;
            for(int j = 0 ; j<len; j++){
                if("0".equals(list[j]) || "5".equals(list[j])){
                    cnt++;
                }
            }
            if(cnt==len){
                numList.add(i);
            }
        }
        if(numList.size()==0){
            return new int[] {-1};
        }


        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
}
