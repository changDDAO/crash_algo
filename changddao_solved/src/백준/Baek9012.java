package 백준;

import java.io.*;

public class Baek9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int left = 0, right = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    left++;
                }
                if (input.charAt(j) == ')') {
                    right++;
                }
                if(right>left) break;
            }
            if (left == right) {
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }

        }
        System.out.println(sb);

    }
}
