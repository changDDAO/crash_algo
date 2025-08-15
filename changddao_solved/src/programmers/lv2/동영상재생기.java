package programmers.lv2;

public class 동영상재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoLen = toSecond(video_len);
        int current = toSecond(pos);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);
        for(String command : commands){
            current = skipOpening(current, opStart, opEnd);
            if(command.equals("next")){
                current = Math.min(videoLen, current+10);
            }else if(command.equals("prev")){
                current = Math.max(0,current-10);
            }
            current = skipOpening(current, opStart, opEnd);
        }
        return toMs(current);
    }


    private int skipOpening(int c, int s, int e){
        if(c>=s && c<= e) c=e;
        return c;
    }

    private int toSecond(String time){
        String [] temp = time.split(":");
        int min = Integer.parseInt(temp[0]);
        int second = Integer.parseInt(temp[1]);
        return min*60 + second;
    }
    private String toMs(int seconds){
        int m = seconds/60;
        int s = seconds%60;
        return String.format("%02d:%02d",m,s);
    }
}
