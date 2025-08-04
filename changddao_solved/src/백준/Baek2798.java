package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2798 {
    static int n, target, res;
    static int [] arr;
    static int [] pickedCard = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        target = Integer.parseInt(input[1]);
        arr = new int[n];
        String[] inputVal = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputVal[i]);
        }
        search(0, 0);
        System.out.println(res);
    }
    static void search(int index, int cnt) {
        if (cnt == 3) {
            int sum = Arrays.stream(pickedCard).sum();
            if (sum <= target && sum> res) {
                res = sum;
            }
            return;
        }
        for(int i = index; i<n; i++){
            pickedCard[cnt] = arr[i];
            search(i+1, cnt+1);
        }
    }
}
