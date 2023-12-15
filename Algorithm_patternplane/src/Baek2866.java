import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek2866 {
    public void Solution() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings;
        int strCnt;
        try {
            strCnt = Integer.parseInt(br.readLine().split(" ")[0]);
            strings = new String[strCnt];
            for (int i = 0; i < strCnt; i++)
                strings[i] = br.readLine();
        }
        catch (Exception e) {
            System.out.println("INPUT ERROR");
            return;
        }

        Queue<List<Integer>> overlapSets = new LinkedList<>();
        final int ALPHABET_SIZE = 26;
        ArrayList<Integer>[] alphabetIdxs = new ArrayList[ALPHABET_SIZE];
        for (int i =0; i < ALPHABET_SIZE; i++)
            alphabetIdxs[i] = new ArrayList<>();

        // Init
        int overlapDepth = 0;
        int currentStr = strings.length-1;
        boolean doOverlapExist = false;

        for (int i = 0; i < strings[currentStr].length(); i++) {
            int alphabetIdx = strings[currentStr].charAt(i) - 'a';
            alphabetIdxs[alphabetIdx].add(i);
        }

        for (ArrayList<Integer> findedPositions : alphabetIdxs) {
            if (findedPositions.size() > 1) {
                doOverlapExist = true;
                List<Integer> copy = new ArrayList<>();
                for (int pos : findedPositions)
                    copy.add(pos);
                overlapSets.add(copy);
            }
            findedPositions.clear();
        }
        overlapDepth += (doOverlapExist?1:0);

        while (true) {
            currentStr--;
            if (overlapSets.isEmpty() || currentStr < 0)
                break;

            int qSize = overlapSets.size();
            doOverlapExist = false;
            while (qSize-- > 0) {
                List<Integer> overlapedIdxs = overlapSets.poll();
                for (int overlapedIdx : overlapedIdxs) {
                    int alphabetIdx = strings[currentStr].charAt(overlapedIdx) - 'a';
                    alphabetIdxs[alphabetIdx].add(overlapedIdx);
                }

                for (ArrayList<Integer> findedPositions : alphabetIdxs) {
                    if (findedPositions.size() > 1) {
                        doOverlapExist = true;
                        List<Integer> copy = new ArrayList<>();
                        for (int pos : findedPositions)
                            copy.add(pos);
                        overlapSets.add(copy);
                    }
                    findedPositions.clear();
                }
            }
            overlapDepth += (doOverlapExist?1:0);
        }

        System.out.println(strCnt - 1 - overlapDepth);
    }
}

