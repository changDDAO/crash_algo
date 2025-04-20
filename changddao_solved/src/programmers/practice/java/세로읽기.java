package programmers.practice.java;

import java.util.*;

class 세로읽기 {
    static List<String> strList = new ArrayList<>();
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for(int i = 0; i<my_string.length(); i+=m){
            String prev= my_string.substring(i, i+m);
            strList.add(prev);
        }
        for(int i=0; i<strList.size();i++){
            sb.append(strList.get(i).charAt(c-1));
        }
        answer= sb.toString();
        return answer;
    }
}