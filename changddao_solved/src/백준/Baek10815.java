package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Baek10815 {
    public static void main(String[] args) throws IOException {
        int n = 0, m = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        /*Map<Integer, Boolean> map = new HashMap<>();
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            map.put(Integer.valueOf(input[i]), true);
        }
        m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(input[i]);
            if (map.containsKey(num)) {
                sb.append("1 ");
            }else{
                sb.append("0 ");
            }
        }*/
        Set<Integer> set = new HashSet<>();
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            set.add(Integer.valueOf(input[i]));
        }
        m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if (set.contains(Integer.parseInt(input[i]))) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}
