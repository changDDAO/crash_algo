package programmers;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        //오른쪽으로 쭉 간 횟수
        int move  = name.length()-1;
        //상,하 비교하기
        for(int i =0; i<name.length();i++){
            answer+=Math.min(name.charAt(i)-'A', 26 - (name.charAt(i)-'A'));
            if(i<name.length()-1 && name.charAt(i+1)=='A'){
                int endA = i+1;
                while(endA< name.length() && name.charAt(endA) =='A')
                    endA++;
                move = Math.min(move, i*2 + name.length()-endA);
                move = Math.min(move, (name.length()-endA)*2 + i);
            }
        }

        return answer + move;
    }
}
