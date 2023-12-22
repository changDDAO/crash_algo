import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10809{
    // 가독성 전략 : 의미있는 고정값은 상수로 의미를 부여할 것
    static final int ALPHABET_SIZE = 26;

    private int getAlphabetIdx(char a){
        return a - 'a';
    }

    public void solution() throws IOException {
        // input 성능 개선 : System.In 또는 Scanner 대신 버퍼를 포함한 스트림 입력으로 사용할 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        // output 성능 개선 : 1. 미리 출력값을 제작하여 한번에 출력하며, 2. 문자열의 빈번한 추가/삭제에는 String대신 StringBuilder를!
        StringBuilder sb = new StringBuilder();

        int[] alphabetPos = new int[ALPHABET_SIZE];
        // Arrays.fill() 기능을 사용하여 대체 가능!
        for (int i = 0; i < ALPHABET_SIZE; i++)
            alphabetPos[i] = -1;

        int alphabetIdx;
        for (int strIdx = 0; strIdx < S.length(); strIdx++){
            alphabetIdx = getAlphabetIdx(S.charAt(strIdx));
            if (alphabetPos[alphabetIdx] == -1)
                alphabetPos[alphabetIdx] = strIdx;
        }

        for (int i = 0; i < ALPHABET_SIZE; i++)
            sb.append(alphabetPos[i]).append(' ');

        System.out.println(sb);
    }
}