package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2563 {
    static boolean[][] paint = new boolean[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            for (int y = startY; y < startY + 10; y++) {
                for (int x = startX; x < startX + 10; x++) {
                    if(paint[y][x])continue;
                    paint[y][x]=true;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paint[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
