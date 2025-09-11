package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int [] targetNum = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(targetNum[i]+" ");
        }
    }
}
