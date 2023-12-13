import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek10809{
    static final int ALPHABET_SIZE = 26;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();


        int[] alphabetPos = new int[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++)
            alphabetPos[i] = -1;

        int alphabetIdx;
        for (int strIdx = 0; strIdx < S.length(); strIdx++){
            alphabetIdx = S.charAt(strIdx) - 'a';
            if (alphabetPos[alphabetIdx] == -1)
                alphabetPos[alphabetIdx] = strIdx;
        }

        for (int i = 0; i < ALPHABET_SIZE; i++)
            sb.append(alphabetPos[i]+" ");

        System.out.println(sb.toString());
    }
}
