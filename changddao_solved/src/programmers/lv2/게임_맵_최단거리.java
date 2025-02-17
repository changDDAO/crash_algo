package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    public int solution(int[][] maps) {
        int [][] nextDir ={{0,1},{0,-1},{1,0},{-1,0}};
        int width = maps[0].length;
        int height = maps.length;
        boolean [][] visited = new boolean[height][width];
        int [][] count = new int[height][width];
        class CurPos {
            private int x;
            private int y;
            public CurPos(int x, int y){
                this.x =x;
                this.y =y;
            }
        }
        Queue<CurPos> q = new LinkedList<>();
        q.offer(new CurPos(0,0));
        visited[0][0]=true;
        count[0][0]=1;
        //q가 비지않았다면 계속
        while(!q.isEmpty()){
            CurPos curpos = q.poll();
            int x = curpos.x;
            int y = curpos.y;
            for(int [] canGo : nextDir){
                int nx = x+canGo[0];
                int ny = y+canGo[1];
                //맵의 영역을 벗어난다면,
                if(nx<0 || nx>= height || ny<0 || ny >=width){
                    continue;
                }
                //방문했던 지점이라면,
                if(visited[nx][ny]){
                    continue;
                }
                //벽으로 둘러쌓여서 갈수있는 곳이 아니라면
                if(maps[nx][ny]==0){
                    continue;
                }
                q.offer(new CurPos(nx, ny));
                count[nx][ny] = count[x][y]+1;
                visited[nx][ny] = true;
            }
        }


        int answer = count[height-1][width-1] == 0 ? -1 : count[height-1][width-1];
        return answer;
    }
}
