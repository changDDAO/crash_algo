package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 9; i++) {
            int res = n * i;
            sb.append(n).append(" ").append("*").append(" ")
                    .append(i).append(" ").append("=").append(" ").append(res).append("\n");
        }
        System.out.println(sb.toString());

    }
}
