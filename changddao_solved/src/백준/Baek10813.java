package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek10813 {
    static int [] src;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        src = new int[n+1];
        for (int i = 1; i < src.length; i++) {
            src[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            swaper(src, a, b);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < src.length; i++) {
            sb.append(src[i]).append(" ");
        }
        System.out.println(sb);

    }
    static void swaper(int []arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
