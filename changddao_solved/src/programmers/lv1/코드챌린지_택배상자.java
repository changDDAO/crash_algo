package programmers.lv1;

public class 코드챌린지_택배상자 {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int height = 0;
        int [] numPos =new int[2];
        height = getHeight(w, n);
        int [][] boxArr = new int[height][w];
        int start = 1;
        setArr(n, num, boxArr,numPos);
        System.out.printf("x, y : %d %d",numPos[0],numPos[1]);
        for(int h = numPos[0]; h<height; h++){
            if(boxArr[h][numPos[1]]!=0){
                answer++;
            }
        }
        return answer;
    }



    public int getHeight(int width, int n){
        int temp = n/width;
        if(n%width!=0){
            temp++;
        }
        return temp;
    }
    public void setArr(int n, int num, int [][] numArr, int[]numPos){
        int width = numArr[0].length;
        int height = numArr.length;
        int start = 1;
        for (int i = 0; i < height; i++) {
            /*짝수이면 오른쪽으로*/
            if(i%2==0){
                for(int j =0; j<width; j++){
                    numArr[i][j]=start++;
                    if(numArr[i][j]==num){
                        numPos[0]=i;
                        numPos[1]=j;
                    }
                    if(start>n)break;
                }
            }else{
                /*홀수이면 왼쪽으로*/
                for(int j=width-1; j>=0; j--){
                    numArr[i][j]=start++;
                    if(numArr[i][j]==num){
                        numPos[0]=i;
                        numPos[1]=j;
                    }
                    if(start>n)break;
                }
            }
        }
    }

}
