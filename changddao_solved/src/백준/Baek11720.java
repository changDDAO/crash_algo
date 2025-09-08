package 백준;

import java.util.Scanner;

public class Baek11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String [] input = sc.nextLine().split("");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(input[i]);
        }
        System.out.println(sum);
    }
}
