
class Function {
    // 문자열로 변환하지 않고도 각 자리의 숫자를 가져오는 방법 개선가능 : 나머지 연산의 활용
    public static int D(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            n += (s.charAt(i) - '0');
        }
        return n;
    }
}

public class Baek4673 {
    private static final int NUM_LIMIT = 10000;
    public void Solution() {
        StringBuilder output = new StringBuilder();

        Boolean[] isSelfNumber = new Boolean[NUM_LIMIT + 1];
        for (int i = 0; i < NUM_LIMIT + 1; i++)
            isSelfNumber[i] = true;

        int dn;
        for (int n = 1; n <= NUM_LIMIT; n++)
            if (isSelfNumber[n]) {
                output.append(n);
                output.append('\n');

                dn = Function.D(n);
                // 이 아래 부분을 돌리지 않고
                // 바로 dn 한번만 검사해도
                // 결과는 동일함에 주의
                while (dn <= NUM_LIMIT && isSelfNumber[dn]) {
                    isSelfNumber[dn] = false;
                    dn = Function.D(dn);
                }
            }

        System.out.print(output);
    }
}
