package programmers;

public class 문자열_여러번_뒤집기 {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();

        for(int query[] : queries){
            int start = query[0];
            int end = query[1];
            while(start<end){
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end]=temp;
                start++;
                end--;
            }

        }
        String answer = new String(arr);
        return answer;
    }
}
