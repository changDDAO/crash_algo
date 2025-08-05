package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int removeCnt = 0;
        int conversionCnt = 0;
        while(!s.equals("1")){
            int originalLen = s.length();
            s = s.replace("0", "");
            int onesCnt = s.length();
            removeCnt += (originalLen - onesCnt);
            s = Integer.toBinaryString(onesCnt);
            conversionCnt++;
        }
        return new int[] {conversionCnt, removeCnt};
    }
}
