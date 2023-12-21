import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1026 {
    static int[] A;
    static int[] B;
    static int n;
    public static void main(String[] args) throws IOException {
        //B의 가장 큰수를 차례로 타겟으로 A의 가장 작은 수를 차례로 곱해준다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += A[i] * B[n - 1 - i];
        }
        System.out.println(result);
    }

}
