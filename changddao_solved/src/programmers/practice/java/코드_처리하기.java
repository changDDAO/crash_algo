package programmers.practice.java;

import java.util.ArrayList;
import java.util.List;

public class 코드_처리하기 {
    public String solution(String code) {
        int mode = 0;
        List<String> retList = new ArrayList<>();
        for(int i=0; i<code.length();i++){
            String temp =String.valueOf(code.charAt(i));

            if(mode == 0){
                if(!temp.equals("1")){
                    if(i%2==0){
                        retList.add(temp);
                    }
                }
            }
            if(mode == 1){
                if(!temp.equals("1")){
                    if(i%2==1){
                        retList.add(temp);
                    }
                }
            }

            if(temp.equals("1")){
                mode = (mode>0) ? 0 : 1;

            }

        }
        if(retList.size()==0){
            return "EMPTY";
        }

        return String.join("",retList);
    }
}
