package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int left=0 , right =0;
            for (int j = 0; j < input.length(); j++) {
                char temp = input.charAt(j);
                if(temp == '('){
                    left++;
                }else{
                    right++;
                }
                if (right > left) {
                    break;
                }
            }
            if (left == right) {
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);


        
    }
}
