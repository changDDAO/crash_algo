package 백준;

import java.util.Scanner;

public class Baek1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int cnt = 0;
        int newNum = n;
        while (true) {
            cnt++;
            int sum = newNum/10 + newNum%10;
            newNum = (newNum%10) * 10  + (sum % 10);
            if(newNum == n){
                break;
            }
        }
        System.out.println(cnt);
        
    }
}
