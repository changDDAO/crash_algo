import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Person {
    public List<Person> friends = new ArrayList<Person>();
    public boolean visited = false;

    public Person getNextValidFriend(Person startPerson) {

        int i = 0;

        if (startPerson != null)  {
            while (i < friends.size() && friends.get(i) != startPerson)
                i++;
            i++;
        }

        while (i < friends.size() && friends.get(i).visited)
            i++;
        if (i == friends.size())
            return null;
        else
            return friends.get(i);
    }
}

class StackData {
    public Person currentPerson;
    public Person currentFriend;

    public StackData(Person currentPerson, Person currentFriend) {
        this.currentPerson = currentPerson;
        this.currentFriend = currentFriend;
    }
}

class Stack {
    private List<StackData> stack = new ArrayList<>();
    private int top = -1;

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(StackData data) {
        stack.add(data);
        top++;
    }

    public StackData pop() {
        StackData result = stack.get(top);
        stack.remove(top--);
        return result;
    }

    public StackData peak() {
        return stack.get(top);
    }
}

public class Baek13023 {

    private Person[] getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Person[] p;
        try {
            String[] input = br.readLine().split(" ");
            int peopleLen = Integer.parseInt(input[0]);
            int connectLen = Integer.parseInt(input[1]);

            p = new Person[peopleLen];
            for (int i = 0; i < peopleLen; i++)
                p[i] = new Person();

            for (int i = 0; i < connectLen; i++){
                input = br.readLine().split(" ");
                int person1 = Integer.parseInt(input[0]);
                int person2 = Integer.parseInt(input[1]);
                p[person1].friends.add(p[person2]);
                p[person2].friends.add(p[person1]);
            }

            return p;

        } catch (Exception e) {
            System.out.println("INPUT_ERROR");
            return null;
        }
    }

    private int FindFriendSize(Person[] people, int findIdx) {

        Stack stack = new Stack();
        int maxVisitedCnt = 0;

        // Init
        int visitedCnt = 0;
        if (!people[findIdx].friends.isEmpty()) {
            stack.push(new StackData(people[findIdx], people[findIdx].friends.get(0)));
            stack.peak().currentPerson.visited = true;
            visitedCnt++;
            maxVisitedCnt = visitedCnt;
        }

        // DFS
        while (!stack.isEmpty()) {
            if (stack.peak().currentFriend != null) {
                StackData nextPersonData = new StackData(
                        stack.peak().currentFriend,
                        stack.peak().currentFriend.getNextValidFriend(null)
                );
                nextPersonData.currentPerson.visited = true;
                stack.peak().currentFriend = stack.peak().currentPerson.getNextValidFriend(stack.peak().currentFriend);
                stack.push(nextPersonData);
                visitedCnt++;

                if (maxVisitedCnt < visitedCnt) {
                    maxVisitedCnt = visitedCnt;
                    if (maxVisitedCnt == 5)
                        return maxVisitedCnt;
                }
            }
            else {
                stack.peak().currentPerson.visited = false;
                stack.pop();
                visitedCnt--;
            }
        }

        return maxVisitedCnt;
    }

    public void Solution() {
        Person[] people = getInput();
        if (people == null)
            return;

        int maxVisitedCnt = 0;
        for (int peopleIdx = 0; peopleIdx < people.length && maxVisitedCnt < 5; peopleIdx++)
            maxVisitedCnt = FindFriendSize(people, peopleIdx);

        System.out.print((maxVisitedCnt == 5 ? 1 : 0));
    }
}
