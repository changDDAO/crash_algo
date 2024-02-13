package programmers.practice;

public class 홀수vs짝수 {
    public int solution(int[] num_list) {
        int answer = 0;
        int evenSum = 0;
        int oddSum = 0;
        //0인덱스를 1 즉 홀수로 여김
        for(int i =0; i<num_list.length; i+=2){
            oddSum+= num_list[i];
        }
        for(int i =1; i<num_list.length; i+=2){
            evenSum+= num_list[i];
        }
        if(oddSum>evenSum){
            answer = oddSum;
        }else if(evenSum>oddSum){
            answer = evenSum;
        }else{
            answer = oddSum;
        }
        return answer;
    }
}
