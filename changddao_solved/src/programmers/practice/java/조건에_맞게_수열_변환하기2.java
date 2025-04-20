package programmers.practice.java;

public class 조건에_맞게_수열_변환하기2 {
    public int solution(int[] arr) {
        int answer = 0;
        int [] copiedArr = new int[arr.length];
        int cnt = 0;
        while(cnt!=arr.length){
            cnt = 0;
            copiedArr = arr.clone();
            for(int i=0; i<arr.length; i++){

                if(arr[i]>=50 && arr[i]%2==0){
                    arr[i]/=2;
                }
                else if(arr[i]<50 && arr[i]%2==1){
                    arr[i] = arr[i]*2+1;
                }
                if(copiedArr[i]==arr[i])cnt++;
            }

            answer++;

        }
        return answer-1;
    }
}
