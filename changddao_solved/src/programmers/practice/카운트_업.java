package programmers.practice;

public class 카운트_업 {
    public int[] solution(int start_num, int end_num) {
        // end_num - start_num+1 이 answer의 length이지만, List를 활용하여 변환해보자
        // List<Integer> numList = new ArrayList<>();
        // for(int i= start_num; i<=end_num;i++){
        //     numList.add(i);
        // }
        // int [] answer = numList.stream().mapToInt(Integer::intValue).toArray();
        // return answer;
        /*  속도 비교해보기
        테스트 1 〉	통과 (2.20ms, 76.8MB)
테스트 2 〉	통과 (3.11ms, 75MB)
테스트 3 〉	통과 (2.98ms, 84MB)
테스트 4 〉	통과 (2.50ms, 73.1MB)
테스트 5 〉	통과 (2.08ms, 74.5MB)
테스트 6 〉	통과 (2.46ms, 73.1MB)
테스트 7 〉	통과 (2.18ms, 76.8MB)
*/
        int [] answer = new int [end_num-start_num+1];
        for(int i= 0; i<answer.length;i++){
            answer[i] = start_num++;
        }
        return answer;
        /*
테스트 1 〉	통과 (0.01ms, 77.3MB)
테스트 2 〉	통과 (0.02ms, 73.8MB)
테스트 3 〉	통과 (0.02ms, 72.5MB)
테스트 4 〉	통과 (0.02ms, 80.7MB)
테스트 5 〉	통과 (0.02ms, 70.3MB)
테스트 6 〉	통과 (0.02ms, 76.6MB)
테스트 7 〉	통과 (0.02ms, 73MB)
테스트 8 〉	통과 (0.02ms, 69.1MB)
테스트 9 〉	통과 (0.02ms, 75.3MB)
        */
    }
}
