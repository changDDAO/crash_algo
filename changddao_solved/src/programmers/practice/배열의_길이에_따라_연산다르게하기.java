package programmers.practice;

public class 배열의_길이에_따라_연산다르게하기 {
    public int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];
        //length가 짝수일 때,
        if(arr.length%2==0){
            for(int i = 0; i<arr.length; i++){
                answer[i] = i%2 == 1 ? arr[i]+n : arr[i];
            }
        }else{
            for(int i = 0; i<arr.length; i++){
                answer[i] = i%2 == 0 ? arr[i]+n : arr[i];
            }
        }
        return answer;
    }
}
