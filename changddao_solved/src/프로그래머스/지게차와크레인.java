package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 지게차와크레인 {
    private int n, m;
    private static int [] dx = {-1, 1, 0, 0};
    private static int [] dy = {0, 0, -1, 1};
    private static final char EMPTY = '.';
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        char [][] map = new char[n][m];
        for(int i=0; i<n; i++){
            map[i] = storage[i].toCharArray();
        }
        for(int i =0; i<requests.length; i++){
            char target = requests[i].charAt(0);
            if(requests[i].length()>=2){
                useCrain(map, target);
            }else{
                bfs(map, target);
            }
        }
        answer = remainingCount(map);
        return answer;
    }
    private boolean isInBound(int x , int y){
        if(x>=0 && x<n && y>=0 && y<m){
            return true;
        }else{
            return false;
        }
    }
    private void bfs(char[][] map, char target){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i<n; i++){
            if(!visited[i][0]){
                q.offer(new int[] {i,0});
            }
            if(!visited[i][m-1]){
                q.offer(new int[] {i,(m-1)});
            }
        }
        for(int j =0; j<m; j++){
            if(!visited[0][j]){
                q.offer(new int[] {0,j});
            }
            if(!visited[n-1][j]){
                q.offer(new int[] {n-1,j});
            }
        }
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            if(x<0 ||x>=n || y<0 || y>=m)continue;
            if(visited[x][y]){continue;}
            visited[x][y] = true;
            if(map[x][y]==target){
                map[x][y] = EMPTY;
                continue;
            }
            if(map[x][y]==EMPTY){
                for(int i=0; i<4; i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(isInBound(nx, ny) && !visited[nx][ny]){
                        q.offer(new int[]{nx, ny});
                    }

                }
            }
        }

    }

    private void useCrain(char[][] map, char target){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j]==target){
                    map[i][j]=EMPTY;
                }
            }
        }
    }
    private int remainingCount(char[][] map){
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j]!=EMPTY){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
