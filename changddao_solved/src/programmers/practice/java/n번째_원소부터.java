package programmers.practice.java;

public class n번째_원소부터 {
    public int[] solution(int[] num_list, int n) {
        int startIdx =  n-1;
        int [] answer = new int[num_list.length-startIdx];
        for(int i=0; i<answer.length;i++){
            answer[i]= num_list[startIdx++];
        }
        return answer;
    }
}
