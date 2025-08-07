package 프로그래머스;

import java.util.Arrays;

public class 삼총사 {
    int [] selected = new int[3];
    int cnt = 0;
    int [] arr;
    public int solution(int[] number) {
        arr = number;
        dfs(0,0);
        return cnt;
    }
    void dfs(int idx, int depth){
        if(depth ==3){
            int sum = Arrays.stream(selected).sum();
            if(sum==0){
                cnt++;
            }
            return;
        }
        for(int i = idx; i< arr.length; i++){
            selected[depth] = arr[i];
            dfs(i+1, depth+1);
        }
    }
}
