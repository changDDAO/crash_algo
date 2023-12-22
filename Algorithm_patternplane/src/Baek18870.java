import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek18870 {
    public void Solution() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pointLen;
        Point[] points;
        Point[] sorted;

        try {
            pointLen = Integer.parseInt(br.readLine());
            points = new Point[pointLen];
            sorted = new Point[pointLen];

            String[] values = br.readLine().split(" ");
            for (int i = 0; i < pointLen; i++) {
                points[i] = new Point();
                points[i].value = Integer.parseInt(values[i]);
                sorted[i] = points[i];
            }
        }
        catch(Exception e) {
            System.out.println("INPUT ERROR");
            return;
        }

        /*
        // rich sort
        for (int i = 0; i < pointLen; i++) {
            int minIdx = i;
            for (int j = i+1; j < pointLen; j++){
                if (sorted[j].value < sorted[minIdx].value)
                    minIdx = j;
            }
            Point tmp = sorted[i];
            sorted[i] = sorted[minIdx];
            sorted[minIdx] = tmp;
        }
         */

        // cheap sort
        PriorityQueue<Point> minHeap = new PriorityQueue<Point>();
        for (int i = 0; i < pointLen; i++)
            minHeap.add(sorted[i]);
        for (int i = 0; i < pointLen; i++)
            sorted[i] = minHeap.poll();

        for (int i = 0, lessCnt = -1, lastestValue = -1; i < pointLen; i++){
            if (sorted[i].value != lastestValue) {
                lastestValue = sorted[i].value;
                lessCnt++;
            }
            sorted[i].amountLessThanThis = lessCnt;
        }

        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < pointLen; i++)
            strB.append(points[i].amountLessThanThis).append(' ');
        System.out.println(strB);
    }
}

class Point implements Comparable<Point>{
    public int value;
    public int amountLessThanThis;

   @Override
    public int compareTo(Point o) {
        return this.value-o.value;
    }
}
