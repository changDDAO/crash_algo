import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Baek18870 {
   /* //Set 사용하기
    static int n;
    static int[] srcNums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> hashSet = new HashSet<>();
        n = Integer.parseInt(br.readLine());
        srcNums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            srcNums[i] = num;
            hashSet.add(num);
        }// srcNums 배열 초기화
                                        //java 17에서는 sorted 다음 바로 toList() 가능
                                        //but, 아래 버전 .collect 써야함.
        List<Integer> sortedArr = hashSet.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int compareTarget = srcNums[i];
            for (int c : sortedArr) {
                if (compareTarget > c)
                    cnt++;
                else break;
            }
            sb.append(cnt).append(" ");
        }

        System.out.println(sb.toString());
    }*/
    static int n;
    static int[] srcNums;
    static int[] sortedNums;
    //HashMap 이용하여 순위 매기기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        n = Integer.parseInt(br.readLine());
        srcNums = new int[n];
        sortedNums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            srcNums[i] = num;
            sortedNums[i] = num;
        }
        Arrays.sort(sortedNums);
        int rank = 0;
        for (int num : sortedNums) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(map.get(srcNums[i])).append(" ");
        }
        System.out.println(sb.toString());
    }

}
