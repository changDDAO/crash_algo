package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> partMap = new HashMap<>();

        //참가자들 Map에 저장
        for(String member : participant){
            partMap.put(member, partMap.getOrDefault(member,0)+1);
        }
        //완주한 참가자들 소거
        for(String complMember : completion){
            partMap.put(complMember, partMap.get(complMember)-1);
        }
        //entrySet 순회하면서 소거안된 즉 값이 0을 초과하는 참가자들 찾기
        for(Map.Entry<String, Integer> member : partMap.entrySet()){
            if(member.getValue()!=0){
                answer = member.getKey();
                break;
            }
        }
        return answer;
    }
}
