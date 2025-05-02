package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 그림확대 {
    public String[] solution(String[] picture, int k) {
        String[] answer = {};
        StringBuilder sb = new StringBuilder();
        List<String> scalePicture = new ArrayList<>();
        for(int i=0; i<picture.length; i++){
            String pixels = picture[i];
            for(int j = 0; j<pixels.length(); j++){
                for(int rate = 0; rate<k; rate ++){
                    sb.append(pixels.charAt(j));
                }
            }
            for(int height=0; height<k; height++){
                scalePicture.add(sb.toString());
            }
            sb.setLength(0);
        }
        return scalePicture.stream().toArray(String[]::new);
    }
}
