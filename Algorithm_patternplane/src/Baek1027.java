import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1027 {
    public void Solution() {
        int buildingCnt;
        int[] heights;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            buildingCnt = Integer.parseInt(br.readLine());
            heights = new int[buildingCnt];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = 0;
            while (st.hasMoreTokens())
                heights[i++] = Integer.parseInt(st.nextToken());

        } catch (Exception e) {
            System.out.println("INPUT ERROR");
            return;
        }

        int[] findBuildings = new int[buildingCnt];
        double LastViewGradient;
        int maxViewCnt = 0;
        for (int buildingIdx = 0; buildingIdx < buildingCnt; buildingIdx++) {
            LastViewGradient = Double.NEGATIVE_INFINITY;
            for (int i = buildingIdx+1; i < buildingCnt; i++) {
                double gradient = (heights[i] - heights[buildingIdx])/(double)(i - buildingIdx);
                if (LastViewGradient < gradient) {
                    LastViewGradient = gradient;
                    findBuildings[buildingIdx]++;
                    findBuildings[i]++;
                }
            }
            if (maxViewCnt < findBuildings[buildingIdx])
                maxViewCnt = findBuildings[buildingIdx];
        }

        System.out.println(maxViewCnt);
    }
}
