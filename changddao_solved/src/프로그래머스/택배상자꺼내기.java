package 프로그래머스;

public class 택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int [][] map = new int[(n+w-1)/w][w];
        int boxOrder = 1;
        for(int i=0; boxOrder<=n; i++){
            if(i%2==0){
                for(int j =0; j<w && boxOrder<=n; j++){
                    map[i][j] = boxOrder++;
                }
            }else{
                for(int j =w-1; j>=0 && boxOrder<=n; j--){
                    map[i][j] = boxOrder++;
                }
            }
        }
        int targetX = -1; int targetY = -1;
        for(int i =0; i<map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                if(map[i][j]== num){
                    targetX = i;
                    targetY = j;
                    break;
                }
            }
        }
        int cnt = 0;
        for(int i=targetX+1; i<map.length; i++){
            if(map[i][targetY]!=0){
                cnt++;
            }
        }

        return cnt+1;
    }
}
