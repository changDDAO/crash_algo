package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baek1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int [] targetList = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            targetList[i] = Integer.parseInt(input[i]);
        }
        int cnt =0;
        for (int target : targetList) {
            int targetIdx = deque.indexOf(target);
            int left = targetIdx;
            int right = deque.size() - targetIdx;
            if (left <= right) {
                for (int i = 0; i < left; i++) {
                    deque.addLast(deque.pollFirst());
                    cnt++;
                }

            }else{
                for (int i = 0; i < right; i++) {
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.poll();
        }
        System.out.println(cnt);

    }
}
