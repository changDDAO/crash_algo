package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2798 {
    static int [] cards;
    static int[] target = new int[3];
    static int n =0, m = 0;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        cards = new int[n];
        input = br.readLine().split(" ");
        for(int i =0;i<n;i++){
            cards[i] = Integer.parseInt(input[i]);
        }
        dfs(0,0);
        System.out.printf("%d",res);
    }
    static void dfs(int index, int depth){
        if(depth == 3){
            int sum = 0;
            for(int i =0; i<target.length;i++){
                sum += target[i];
            }
            if (sum > res && sum <= m) {
                res = sum;
            }
            return;
        }
        for(int i = index; i < cards.length; i++){
            target[depth] =  cards[i];
            dfs(index+1, depth+1);
        }
    }
}
