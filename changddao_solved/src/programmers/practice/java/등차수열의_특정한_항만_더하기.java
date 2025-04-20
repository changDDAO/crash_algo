package programmers.practice.java;

public class 등차수열의_특정한_항만_더하기 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int start = a;
        int diff = d;
        int [] list = new int[included.length];
        list[0]=start;
        for(int i=1; i<list.length; i++){
            list[i]=list[i-1]+diff;
        }
        for(int inc =0; inc<included.length; inc++){
            if(included[inc]){
                answer+=list[inc];
            }
        }

        return answer;
    }
}
