package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String tmp = br.readLine();
            int num = Integer.parseInt(tmp);
            numList.add(num%42);
        }


        for(int i=0;i<numList.size();i++){
            for(int j=0;j<numList.size();j++){
                if(numList.get(j).equals(numList.get(i))){
                    Integer target = numList.get(i);
                    for(int k=0; k<numList.size();k++){
                        if(numList.get(k).equals(target)){
                            numList.remove(k);
                        }
                    }
                }
            }
        }
        System.out.println(numList);
        System.out.println(numList.size());
    }
}
