import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2579 {
    static int n;
    static int [] stairs;
    static int [] dpTable;
    /*
     * i)dp[i]에 담길 값 i번째 계단 까지의 최댓값
     * dp[i-3]+ stairs[i-1] + stairs[i]
     * dp[i-2]+stairs[i] 중 큰값
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
        dpTable = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dpTable[1] = stairs[1];
        //n이 1이 입력이 되면 dp[2]나 stairs[2]는 bound error가 난다.
        if(n>=2) dpTable[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            dpTable[i] = Math.max(dpTable[i - 2] + stairs[i], dpTable[i - 3] + stairs[i - 1] + stairs[i]);
        }
        System.out.println(dpTable[n]);
    }




}
