package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek4659 {
    //같은 문자 연속으로 2개 X But, e와 o 는 허용 단, 2개까지만
    final static String ok = "> is acceptable.\n";
    final static String not = "> is not acceptable.\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            boolean pass = false;
            char prev = '!';
            int cnt = 0;
            if (input.equals("end")) { //입력받은 문자열이 "end" 라면 반복문 종료 & 출력
                System.out.println(sb.toString());
                break;
            }
            char[] password = input.toCharArray();
            for (char p : password) {
                if(checkAlphabet(p)){
                    pass= true;
                }
                //모음또는 자음이 각각 중복되면 cnt 증가
                if(checkAlphabet(p)!=checkAlphabet(prev)) cnt=1;
                else cnt++;
                //모음또는 자음이 연속으로 3개이상 이거나, 이전문자와 중복이 되는데 e와 o가 아닌 경우,
                if (cnt >= 3 || (prev == p && (p != 'e' && p != 'o'))) {
                    pass = false;
                    break;
                }
                prev = p;
            }
            if (pass) {
                sb.append("<").append(input).append(ok);
            }else{
                sb.append("<").append(input).append(not);
            }
        }



    }

    static boolean checkAlphabet(char c) {  //true 이면 모음, false 이면 자음
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
