import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2866 {
    public void Solution() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings;
        int R, C;
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            strings = new String[R];
            for (int i = 0; i < R; i++)
                strings[i] = br.readLine();
        }
        catch (Exception e) {
            System.out.println("INPUT ERROR");
            return;
        }

        // 중복된 인덱스(열)의 묶음은 연결리스트로 표현됨.
        // overlapSets : 이전 층까지 중복되었던 인덱스(열)들의 묶음을 담는 큐
        // idxsInAlphabet : 현재 층에서, 특정 알파벳을 가지는 인덱스(열)별 들을 담기 위한 배열
        Queue<IdxNode> overlapSets = new LinkedList<>();
        final int ALPHABET_SIZE = 26;
        IdxsInfo[] idxsInAlphabet = new IdxsInfo[ALPHABET_SIZE];
        for (int i = 0; i < idxsInAlphabet.length; i++)
            idxsInAlphabet[i] = new IdxsInfo();

        // 동작 :
        // 아랫단(가장 마지막 행)에서부터 위로 올라오면서
        // 중복된 열이 최대 어느높이(행)까지 존재하는지 탐색

        // 초기화
        // => 처음엔 모든 열이 서로 다 중복되었다고 가정
        int currentLine = strings.length;
        IdxNode startNode = null;
        for (int i = 0; i < C; i++) {
            IdxNode newNode = new IdxNode();
            newNode.index = i;
            newNode.next = startNode;
            startNode = newNode;
        }
        overlapSets.add(startNode);

        // 동작
        while (!overlapSets.isEmpty()) {
            currentLine--;

            int setCnt = overlapSets.size();
            while (setCnt-- > 0) {
                // 1. 이전 층까진 중복이었던 인덱스(열)들의 묶음을 하나 꺼내어,
                //    다시 인덱스(열)별 현재 층의 알파벳 분포를 작성
                IdxNode currentIdx = overlapSets.poll();
                IdxNode nextIdx;
                while (currentIdx != null) {
                    nextIdx = currentIdx.next;

                    int alphabet = strings[currentLine].charAt(currentIdx.index) - 'a';
                    idxsInAlphabet[alphabet].addIdx(currentIdx);
                    currentIdx = nextIdx;
                }

                // 2. 현재 층에서도 여전히 서로 중복인 인덱스(열)들을 다시 간추려서
                //    다음층 작업에도 반영하기 위해 큐에 저장
                for (IdxsInfo idxs : idxsInAlphabet) {
                    if (idxs.getCnt() > 1)
                        overlapSets.add(idxs.popAll());
                    else
                        idxs.popAll();
                }
            }
        }

        System.out.println(currentLine);
    }
}

class IdxsInfo {
    private int cnt = 0;
    private IdxNode startNode = null;
    public void addIdx(IdxNode node){
        node.next = startNode;
        startNode = node;
        cnt++;
    }
    public IdxNode popAll() {
        IdxNode result = startNode;
        startNode = null;
        cnt = 0;
        return result;
    }
    public int getCnt() {
        return cnt;
    }
}

class IdxNode {
    public int index;
    public IdxNode next;
}