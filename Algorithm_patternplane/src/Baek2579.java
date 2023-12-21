import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2579 {

    private int stairCnt;
    private int[] stairs;

    public void Solution() {
        if (!getInput())
            return;

        int pointCnt = 0;
        for (int stairIdx = -1; stairIdx < stairCnt;) {
            int jumpIdx = getJumpIdx(stairIdx);
            if (jumpIdx == -1) {
                if (stairIdx != -1) {
                    pointCnt += stairs[stairIdx];
                    System.out.println(stairIdx);
                }
                stairIdx++;
            }
            else {
                for (int i = 0; i < jumpIdx; i++) {
                    if (stairIdx + i != -1) {
                        pointCnt += stairs[stairIdx + i];
                        System.out.println(stairIdx);
                    }
                }
                stairIdx += jumpIdx + 1;
            }
        }

        System.out.println(pointCnt);
    }

    private boolean getInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            stairCnt = Integer.parseInt(br.readLine());
            stairs = new int[stairCnt];

            for (int i = 0; i < stairCnt; i++)
                stairs[i] = Integer.parseInt(br.readLine());

            return true;
        } catch (Exception e) {
            System.out.println("INPUT ERROR");
            return false;
        }
    }

    private int getJumpIdx(int stairIdx) {

        if (stairIdx == -1) {
            if (stairIdx + 1 == stairCnt - 1)
                return -1;
            else if (stairIdx + 2 == stairCnt - 1)
                return -1;
            else if (stairIdx + 3 == stairCnt - 1)
                return 2;
            else {
                if (stairs[stairIdx+1] > stairs[stairIdx+2]) {
                    if (stairs[stairIdx+2] > stairs[stairIdx+3])
                        return 3;
                    else
                        return 2;
                }
                else {
                    if (stairs[stairIdx+1] > stairs[stairIdx+3])
                        return 3;
                    else
                        return 1;
                }
            }
        }

        else {
            if (stairIdx == stairCnt - 1)
                return -1;
            else if (stairIdx == (stairCnt - 1) - 1)
                return -1;
            else if (stairIdx == (stairCnt - 1) - 2)
                return 1;
            else {
                if (stairs[stairIdx+2] < stairs[stairIdx+1])
                    return 2;
                else
                    return 1;
            }
        }
    }
}
