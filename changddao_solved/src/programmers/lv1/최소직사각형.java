package programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class 최소직사각형 {

        public int solution(int[][] sizes) {
            ArrayList<Integer> widthList = new ArrayList<>();
            List<Integer> heightList = new ArrayList<>();
            for(int i= 0 ; i<sizes.length; i++){
                int width = Math.max(sizes[i][0], sizes[i][1]);
                int height = Math.min(sizes[i][0], sizes[i][1]);
                widthList.add(width);
                heightList.add(height);
            }
            OptionalInt highWidth = widthList.stream().mapToInt(Integer::intValue).max();
            OptionalInt highHeight = heightList.stream().mapToInt(Integer::intValue).max();
            return highWidth.getAsInt() * highHeight.getAsInt();
        }
}
