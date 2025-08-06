package 프로그래머스;

class PCCP1 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSeconds(video_len);
        int current = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                current = Math.max(0, current - 10);
            } else if (cmd.equals("next")) {
                if (current >= opStart && current <= opEnd) {
                    current = opEnd;
                }
                current = Math.min(videoLen, current + 10);
            }


            if (current >= opStart && current <= opEnd) {
                current = opEnd;
            }
        }

        return toMs(current);
    }

    private int toSeconds(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    private String toMs(int seconds) {
        int minute = seconds / 60;
        int second = seconds % 60;
        return String.format("%02d:%02d", minute, second);
    }
}
