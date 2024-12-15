package programmers.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 수_조작하기2 {
    public String solution(int[] numLog) {
            String answer = "";
            List<Character> charList = new ArrayList<>();
            for(int i = 1; i<numLog.length; i++){
                if(numLog[i]-numLog[i-1]==1){
                    charList.add('w');
                    continue;
                }
                if(numLog[i]-numLog[i-1]==-1){
                    charList.add('s');
                    continue;
                }
                if(numLog[i]-numLog[i-1]==10){
                    charList.add('d');
                    continue;
                }
                if(numLog[i]-numLog[i-1]==-10){
                    charList.add('a');
                    continue;
                }
            }
            answer = charList.stream().
                    map(String::valueOf).collect(Collectors.joining());


            return answer;
        }

}
