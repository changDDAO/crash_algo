import java.util.StringTokenizer;

public class Baek4673 {

    static boolean[] nums = new boolean[10001];
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            int checkNum = created(i);
            if (checkNum <= 10000) {
                nums[checkNum] = true;
            }
        }
        for (int i = 1; i <= 10000; i++) {
            if (!nums[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int created(int num) {
        int sum = num;
        while (num > 0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }


}
