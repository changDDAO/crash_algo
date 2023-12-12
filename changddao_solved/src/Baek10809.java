import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek10809{
    static char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        for (int i = 0; i < alphabets.length; i++) {
            char target = alphabets[i];
            if (S.contains(String.valueOf(target))) {
                sb.append(S.indexOf(target)).append(" ");
            } else {
                sb.append(-1).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
