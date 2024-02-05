package programmers.practice;

public class 정수_찾기 {  public int solution(int[] num_list, int n) {
    int answer = 0;
    for(int i=0;i<num_list.length;i++){
        if(num_list[i]==n){
            answer = 1;
            break; //효율성을 위해서 찾자마자 for문탈출
        }
    }
    return answer;
}
}
