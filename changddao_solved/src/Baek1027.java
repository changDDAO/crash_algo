import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1027 {
    static int[] buildingHeight;
    static int[] visibleBuildingCnt;
    static int n;
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
         buildingHeight = new int[n];
         visibleBuildingCnt = new int[n];

         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < n; i++) {
             buildingHeight[i] = Integer.parseInt(st.nextToken());
         }
         for (int i = 0; i < n - 1; i++) {
             //바로 옆건물은 서로 보임
             visibleBuildingCnt[i]++;
             visibleBuildingCnt[i+1]++;
             double curGradient = buildingHeight[i + 1] - buildingHeight[i];
             for (int j = i + 2; j < n; j++) {
                 double nextGradient = calcGradient(i, j);
                 if (nextGradient > curGradient) {
                     visibleBuildingCnt[i]++;
                     visibleBuildingCnt[j]++;
                     curGradient = nextGradient;
                 }
             }
         }
         int max = Arrays.stream(visibleBuildingCnt).max().orElse(0);
         System.out.println(max);
     }

    static double calcGradient(int x1, int x2) {
        return (double) (buildingHeight[x2] - buildingHeight[x1]) / (x2 - x1);
    }
}
