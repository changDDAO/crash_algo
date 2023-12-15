import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2866 {
    static List<String> seroStrs = new ArrayList<>();
    static int R, C;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char [][] strTable = new char[R][C];
        for (int i = 0; i < R; i++) {
            strTable[i] = br.readLine().toCharArray();
        }
        /*System.out.println("[1][1]"+ strTable[1][1]);*/
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            sb.setLength(0); //처음에는 당연히 0이지만 다음 for문을 순회할 때, 초기화 필요
            for(int j=0; j<R; j++){
                sb.append(strTable[j][i]);
            }
            seroStrs.add(sb.toString());
        }
        /*for (String temp : seroStr) { // 세로 스트링 잘나옴
            System.out.println("temp = " + temp);
        }    */
        biSearch();
        System.out.println(answer);
    }

    private static void biSearch() {
        int start = 0;
        int end = R-1;
        List<String> partStrs = new ArrayList<>();
        while (start <= end) {
            int mid = (start + end) / 2;
            partStrs.clear();
            for (int i = 0; i < C; i++) {
                String seroStr = seroStrs.get(i);
                String partStr = seroStr.substring(mid);
                if (!partStrs.contains(partStr)) {
                    partStrs.add(partStr);
                }
            }
            /*다 순회하고 원래 seroStrs와 size()가 같다면?
            * 중복값이 없는 것 그렇다면 한줄 더내려가서 탐색(mid +1)*/
            if (partStrs.size() == seroStrs.size()) {
                start = mid + 1;
                answer = mid;
            } else { //중복값이 존재한다는 것이므로 end값 줄이기 (mid-1)
                end = mid -1;
            }
        }
    }
}
