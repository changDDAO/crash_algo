import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Baek2667 {

    private int mapSize;
    private char[][] map;

    public void Solution() {
        if (!getInput())
            return;

        List<Integer> setSizes = new ArrayList<>();

        Stack<CheckPoint> stack = new Stack<>();
        for (int i = 0; i < mapSize; i++)
            for (int j = 0; j < mapSize; j++)
                if (map[i][j] == '1') {
                    int setSize = 0;
                    stack.clear();
                    stack.add(new CheckPoint(j,i));
                    map[i][j] = 'd';
                    setSize++;
                    while (!stack.isEmpty()) {
                        CheckPoint p = stack.pop();

                        if (p.x-1 >= 0
                        && map[p.y][p.x-1] == '1') {
                            stack.add(new CheckPoint(p.x - 1, p.y));
                            map[p.y][p.x-1] = 'd';
                            setSize++;
                        }
                        if (p.x+1 < mapSize
                                && map[p.y][p.x+1] == '1') {
                            stack.add(new CheckPoint(p.x + 1, p.y));
                            map[p.y][p.x+1] = 'd';
                            setSize++;
                        }
                        if (p.y-1 >= 0
                                && map[p.y-1][p.x] == '1') {
                            stack.add(new CheckPoint(p.x, p.y - 1));
                            map[p.y-1][p.x] = 'd';
                            setSize++;
                        }
                        if (p.y+1 < mapSize
                                && map[p.y+1][p.x] == '1') {
                            stack.add(new CheckPoint(p.x, p.y + 1));
                            map[p.y+1][p.x] = 'd';
                            setSize++;
                        }
                    }
                    setSizes.add(setSize);
                }

        setSizes.sort(Integer::compare);

        System.out.println(setSizes.size());
        for (Integer setSize : setSizes)
            System.out.println(setSize);
    }

    private boolean getInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            mapSize = Integer.parseInt(br.readLine());
            map = new char[mapSize][];

            for (int i = 0; i < mapSize; i++)
                map[i] = br.readLine().toCharArray();

            return true;
        } catch (Exception e) {
            System.out.println("INPUT ERROR");
            return false;
        }
    }
}

class CheckPoint {
    public int x;
    public int y;
    public CheckPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}