package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Beak1157 {
    static int[] alpha = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (Character.isUpperCase(temp)) {
                temp = Character.toLowerCase(temp);
            }
            int asVal = (int) temp;
            alpha[asVal - 97]++;
        }
        int max = Arrays.stream(alpha).max().getAsInt();
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == max) {
                res = i;
                cnt++;
            }
            if (cnt > 1) {
                sb.append("?");
                break;
            }
        }
        char answer = (char) (97 + res);
        char upperCase = Character.toUpperCase(answer);
        sb.append(upperCase);
        if (sb.length() > 1) {
            System.out.println("?");
        }else{
            String substring = sb.substring(sb.length() - 1, sb.length());
            System.out.println(substring);
        }
    }

}
