package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        for(int i =0; i<callings.length; i++){
            String name = callings[i];
            int getIdx = map.get(name);
            String prevName = players[getIdx-1];
            players[getIdx - 1] = name;
            players[getIdx]=prevName;
            map.put(name, getIdx-1);
            map.put(prevName,getIdx);
        }
        answer = players;
        return answer;
    }
}
