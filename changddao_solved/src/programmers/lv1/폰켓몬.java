package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> pocMap = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            pocMap.put(nums[i],pocMap.getOrDefault(nums[i],0)+1);
        }
        if(pocMap.size()>=nums.length/2){
            answer = nums.length/2;
        }else{
            answer = pocMap.size();
        }
        return answer;

    }
}
