import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 0;
        int answer = 0;
        //그리디 잘못 걸리면 박살남...
        for (int i = 1; i < m - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                cnt++;
                if(cnt==n){
                    cnt--;
                    answer++;
                }
                i++;
            }else{
                cnt=0;
            }
        }
        System.out.println(answer);
    }
}
//IOIOIOI