package programmers.lv2;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        //오른쪽으로 쭉 간 횟수2
        int move  = name.length()-1;
        //상,하 비교하기
        for(int i =0; i<name.length();i++){  //CCCCAAAAAAAAAABCB 17 -14
            answer+=Math.min(name.charAt(i)-'A', 26 - (name.charAt(i)-'A'));
            if(i<name.length()-1 && name.charAt(i+1)=='A'){
                int endA = i+1;
                while(endA< name.length() && name.charAt(endA) =='A')
                    endA++;
                move = Math.min(move, i*2 + name.length()-endA);//오른쪽으로 시작해서 움직이다가
                //다시 돌아와서 뒤로 움직인횟수를 count
                move = Math.min(move, (name.length()-endA)*2 + i);
                // 뒤로움직였다가 시작지점으로 돌아와서 오른쪽 count해나가기
            }
        }

        return answer + move;
    }
}
