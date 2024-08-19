package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*이기면 3점 비기면 각각 1점  패자 0점*/
public class Baek2511 {
    //A의값을 담을 변수
    static List<Integer> listA;
    //B의값을 담을 변수
    static List<Integer> listB;
    /*listA의 점수*/
    static int aScore;
    /*listB의 점수*/
    static int bScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        listA = Arrays.stream(temp).map(Integer::parseInt).collect(Collectors.toList());
        temp = br.readLine().split(" ");
        listB = Arrays.stream(temp).map(Integer::parseInt).collect(Collectors.toList());

        for(int i =0; i<listA.size(); i++){
            if(listA.get(i) == listB.get(i)){
                aScore+=1;
                bScore+=1;
            }
            if(listA.get(i)>listB.get(i)){
                aScore+=3;
            }
            if(listA.get(i)<listB.get(i)){
                bScore+=3;
            }
        }
        /*for문 순회하면서 aScore와 bScore의 최종적인 합산은 다된 상황*/
        sb.append(aScore).append(" ").append(bScore).append("\n");
        if (aScore > bScore) {
            sb.append("A");
        }else if (bScore > aScore) {
            sb.append("B");
        }else{
          /*비긴상황*/
            /*가능한 경우의 수
            * 1. 비기긴했는데 끝에서 부터 0번 인덱스 까지 backtracking 하면서 더큰 숫자가 있는경우 그 친구가 승자*/
            /*2. 끝에서부터 0까지 모든 숫자가 같은경우*/
            for(int k= listA.size()-1;k>=0;k--){
                if(listA.get(k)>listB.get(k)){
                    sb.append("A");
                    break;
                }
                if(listA.get(k)<listB.get(k)){
                    sb.append("B");
                    break;
                }
                if (k == 0) {
                    if (listA.get(k) == listB.get(k)) {
                        sb.append("D");
                    }
                }

            }

        }
        System.out.println(sb.toString());
    }
}
