package 백준;

import java.util.Scanner;

public class Baek27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int pos = sc.nextInt();
        char temp = input.charAt(pos-1);
        System.out.println(temp);
    }
}
