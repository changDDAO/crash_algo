package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek16139 {
    static int start, end, n;
    static char[] inputArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        inputArr = temp.toCharArray();
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            sb.append(countAlphabet(target, start, end)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int countAlphabet(char target, int start, int end) {
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            if(inputArr[i]-target==0)cnt++;
        }
        return cnt;
    }
}
/*//문제를 다풀고 부분성공이라 나와서 알고리즘분류를 확인 해보니 누적합이었다.
// 근데 잘 생각해보자 누적합의 경우라면 첫번째 문자로 주어지는게 항상 일치해야한다.
// 그래야 그문자를 기준으로 누적합을 만들 수 있다. 다른 문자가 주어지게 되면 안되는 즉 약간 억지성으로
// 가져다 붙힌 누적합 문제가 아닌가? 라는 생각이 든다.
// 각 case 마다  이문제의 경우 첫번째로 주어지는
// 문자가 항상 같을 것이다.
가만 또 가능은 할것같다 ㅋㅋㅋ 근데 누적합을 이래 가져다 붙히는게 맞나싶다
*/
