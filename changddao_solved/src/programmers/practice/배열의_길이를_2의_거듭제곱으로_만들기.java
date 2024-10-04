package programmers.practice;

import java.util.Arrays;

public class 배열의_길이를_2의_거듭제곱으로_만들기 {
    public int[] solution(int[] arr) {
        int pow = 1;
        while(pow<arr.length){
            pow *=2;
        }
        int [] answer = Arrays.copyOf(arr, pow);
        return answer;
    }
}
