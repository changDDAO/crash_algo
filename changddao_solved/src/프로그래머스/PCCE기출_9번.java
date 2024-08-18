package 프로그래머스;

public class PCCE기출_9번 {
    //동서남북 방향 정의하기
    static int[] dx = {1,0,-1,0};//세로방향 정의
    static int[] dy = {0,1,0,-1};//가로방향 정의
    static boolean[][] visited;
    static String[][] map;
    static int answer;

    public int solution(String[][] board, int h, int w) {

        map = board;
        int width = board[0].length;
        int height = board.length;
        visited = new boolean[height][width];
        bfs(h,w);
        return answer;
    }
    static void bfs(int x, int y){
        String color = map[x][y];
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||nx>=map.length||ny<0||ny>=map[0].length) continue;
            if(!map[nx][ny].equals(color))continue;
            answer++;
        }
    }


}
