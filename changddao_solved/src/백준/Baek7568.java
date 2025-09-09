package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            String [] input =  br.readLine().split(" ");
            people[i][0] = Integer.parseInt(input[0]);//몸무게
            people[i][1] = Integer.parseInt(input[1]);//키
        }
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(people[j][0]>people[i][0]&&people[j][1]>people[i][1]){
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb.toString());
    }
}
