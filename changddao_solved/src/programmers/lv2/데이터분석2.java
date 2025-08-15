package programmers.lv2;

import java.util.Arrays;
import java.util.List;

public class 데이터분석2 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<String> col = Arrays.asList("code","date","maximum","remain");
        int extIdx = col.indexOf(ext);
        int sortIdx = col.indexOf(sort_by);
        answer = Arrays.stream(data).filter(o -> o[extIdx]<val_ext)
                .sorted((o1, o2) -> Integer.compare(o1[sortIdx], o2[sortIdx])).toArray(int[][]::new);


        return answer;
    }
}
