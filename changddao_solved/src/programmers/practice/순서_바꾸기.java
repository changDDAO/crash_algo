package programmers.practice;

public class 순서_바꾸기 {public int[] solution(int[] num_list, int n) {
    int[] answer = new int[num_list.length];
    int startIdx  = n;
    for(int i=0; i<num_list.length-n;i++){
        answer[i]=num_list[startIdx++];
    }
    int restIdx = 0;
    for(int i = num_list.length-n;i<num_list.length ;i++){
        answer[i] = num_list[restIdx++];
    }


    return answer;
}
    /*public int[] solution(int[] num_list, int n) {
        int idx = 0;
        int[] answer = new int[num_list.length];
        for (int i = n;i < num_list.length;i++)
            answer[idx++] = num_list[i];
        for (int i = 0;i < n;i++)
            answer[idx++] = num_list[i];
        return answer; 다른사람의 코드 (좀더 깔끔)
    }
    */
}
