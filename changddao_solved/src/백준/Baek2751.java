package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek2751{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numList.add(Integer.parseInt(br.readLine()));
        }
        numList.sort((a,b)-> a-b);
        for (int i = 0; i < numList.size(); i++) {
            sb.append(numList.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
