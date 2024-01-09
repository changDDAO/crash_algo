public class 덧칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int curWall = 0;

            for (int i = 0; i < section.length; i++) {
                if (curWall < section[i]) {
                    answer++;//색칠
                    curWall = section[i] + m - 1;// 현재까지 색칠된 벽의 Index
                }


            }
            return answer;
        }

    }
}

