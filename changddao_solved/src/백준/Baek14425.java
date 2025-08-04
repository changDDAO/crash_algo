package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Baek14425 {

    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            set.add(temp);
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            if (set.contains(temp)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
