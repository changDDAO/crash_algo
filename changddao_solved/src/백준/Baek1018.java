package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1018 {
    static boolean[][] map;
    static int res = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        map = new boolean[n][m];
        for(int i =0; i<n; i++){
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'W') {
                    map[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                toggleCnt(i, j);
            }
        }
        System.out.println(res);

    }
    static void toggleCnt(int a, int b) {
        int lastHeight = a + 8;
        int lastWidth = b + 8;
        boolean color = map[a][b];
        int cnt = 0 ;
        for (int i = a; i < lastHeight; i++) {
            for (int j = b; j < lastWidth; j++) {
                if (color != map[i][j]) {
                    cnt++;
                }
                color = !color;
            }
            color = !color;
        }
        int min = Math.min(cnt, 64 - cnt);
        res = Math.min(res, min);
    }
}
