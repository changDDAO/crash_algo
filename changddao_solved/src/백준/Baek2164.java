package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll();           // 제일 위 카드를 버림
            q.offer(q.poll());  // 다음 카드를 맨 뒤로 이동
        }

        System.out.println(q.poll()); // 마지막 카드 출력
    }
}
