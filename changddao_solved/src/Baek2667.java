import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2667 {
    //동서남북 방향 정의하기
    static int[][] nextDir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static List<Integer> houses = new ArrayList<>();
    static int n;
    static int[][] map ;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        //map 초기화
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    bfs(i,j);
                    houses.add(count);
                }
            }
        }
        sb.append(houses.size()).append("\n");
        Collections.sort(houses);
        for(int houseSize : houses){
            sb.append(houseSize).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int x, int y) {
        count =0;
        Queue<int[]> q = new LinkedList<>();
        map[x][y] = 0;
        count++;
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] nextHouse = q.poll();
            int row = nextHouse[0];
            int col = nextHouse[1];
            for(int[] next : nextDir){
                int nx = row+next[0];
                int ny = col+next[1];
                //범위를 벗어난다면
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(map[nx][ny]==0) continue;
                q.offer(new int[]{nx, ny});
                map[nx][ny]= 0;
                count++;
            }
        }


    }
}
