package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2231 {
    /*분해합
    * def) 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자
    * ex) 245의 분해합이 245 + 2+ 4 + 5  = 256
    * 245는 256의 생성자
    * 자연수 N이 주어질 때 가장 작은 생성자 찾기(없을수도, 생성자가 여러개일 수도 있다. 여러개있을 경우 가장 작은것)
    * 216의 경우, 출력값으로 198이 나왔지만 이것은 생성자 중에 가장 작은 수임
    * */
    static int answer;
    /*임시 변수*/
    static int temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            /*각 자릿 수의 합을 담을 변수*/
            int sum = 0;
            temp = i;

            while(temp!=0){
                sum += temp % 10;
                temp/=10;
            }
            if (sum + i == n) {
                /*여기서 i는 생성자이다.*/
                answer = i;
                break; //이부분이 포인트인데 생각해보면 생성자가 여러개 있을 경우, break처리를 안했을 때 가장 큰 생성자의 값이 최종적으로 담기게 될것이라 예상됨
            }
        }
        /*if문 자체를 타질 않으면 static으로 선언했기 때문에 기본 default값이 0으로 초기화됨*/
        System.out.println(answer);
    }
}
