package programmers.practice;

public class 배열의_원소만큼_추가하기 {
    public int[] solution(int[] arr) {
        int sum = 0;
        for(int i =0; i<arr.length; i++){
            sum+= arr[i];
        }
        int[] answer = new int[sum];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            for(int v =0; v<val; v++){
                answer[idx++] =  val;
            }
        }

        return answer;
    }
}
