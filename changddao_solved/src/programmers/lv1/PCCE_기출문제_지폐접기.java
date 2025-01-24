package programmers.lv1;

public class PCCE_기출문제_지폐접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(Math.min(bill[0], bill[1])>Math.min(wallet[0],wallet[1])
                ||Math.max(bill[0],bill[1])>Math.max(wallet[0],wallet[1])){
            if(bill[0]>=bill[1]){
                bill[0]/=2;
                answer++;
            }else{
                bill[1]/=2;
                answer++;
            }
        }
        return answer;
    }
}
