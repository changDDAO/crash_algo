package programmers.lv1;

public class 삼총사 {
    static int result = 0;
    static int [] std = new int[3];
    static int n;
    static int [] refNumber;
    public int solution(int[] number) {
        int answer = 0;
        n = number.length;
        refNumber = number;
        dfs(0,0);
        answer = result;
        return answer;
    }
    //완전탐색 메서드 만들기
    /* 삼총사니까 depth=3 까지*/
    public void dfs(int idx, int depth){
        if(depth==3){
            int sum = 0;
            for(int i =0; i<std.length; i++){
                sum+= std[i];
            }
            if(sum == 0){
                result++;
            }
            return;
        }
        for(int i = idx; i<n;i++){
            std[depth] = refNumber[i];
            dfs(i+1,depth+1);
        }
    }
}
