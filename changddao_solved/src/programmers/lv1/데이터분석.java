package programmers.lv1;

import java.util.Arrays;
import java.util.List;

public class 데이터분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<String> colList = Arrays.asList("code","date","maximum","remain");
        int extIdx = colList.indexOf(ext);
        int sortIdx = colList.indexOf(sort_by);
        answer = Arrays.stream(data).filter(o -> o[extIdx]<val_ext)
                .sorted((fo1, fo2) -> fo1[sortIdx]-fo2[sortIdx]).toArray(int[][]::new);

        return answer;
    }
}
