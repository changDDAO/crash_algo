package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Baek10920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<String, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
        String temp = br.readLine();
            if (temp.length() >= m) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        List<String> strList = new ArrayList<>(map.keySet());
        strList.sort((a,b)->{
            int frequenA = map.get(a);
            int frequenB = map.get(b);
            if(frequenA!=frequenB){
                return frequenB-frequenA;//desc
            }
            if(a.length()!=b.length()){
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strList.size();i++){
            sb.append(strList.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
