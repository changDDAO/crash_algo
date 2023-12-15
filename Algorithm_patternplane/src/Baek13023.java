import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Person {
    private final List<Person> primitiveFriends = new ArrayList<Person>();
    public Person[] friends;
    public boolean visited = false;

    public void addFriend(Person f) {
        primitiveFriends.add(f);
    }

    public void makeArray() {
        friends = primitiveFriends.toArray(new Person[0]);
    }
}

class StackData{
    public Person currentPerson;
    public int friendIdx;
    public StackData(Person currentPerson, int friendIdx) {
        this.currentPerson = currentPerson;
        this.friendIdx = friendIdx;
    }
}

class Stack {
    private final List<StackData> stack = new ArrayList<>();
    private int top = -1;

    public void clear() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(Person currentPerson, int friendIdx) {
        top++;
        if (top >= stack.size())
            stack.add(new StackData(currentPerson, friendIdx));
        else {
            stack.get(top).currentPerson = currentPerson;
            stack.get(top).friendIdx = friendIdx;
        }
    }

    public StackData pop() {
        return stack.get(top--);
    }

    public StackData peak() {
        return stack.get(top);
    }
}

class Inputter{
    public static Person[] getInput() {
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
                p[person1].addFriend(p[person2]);
                p[person2].addFriend(p[person1]);
            }

            for (int i = 0; i < peopleLen; i++)
                p[i].makeArray();

            return p;

        } catch (Exception e) {
            System.out.println("INPUT_ERROR");
            return null;
        }
    }
}

class DFSFriendLineTracer{

    private static final Stack stack = new Stack();

    public static boolean findFriendLine(Person[] people, int startPerson, int friendDistance) {

        // Init
        stack.clear();
        people[startPerson].visited = true;
        int friendDis = 1;
        stack.push(people[startPerson], -1);

        // DFS
        while (!stack.isEmpty()) {

            Person currentPerson = stack.peak().currentPerson;

            // get next friend
            int nextFriendIdx = -1;
            for (int i = stack.peak().friendIdx + 1; i < currentPerson.friends.length; i++)
                if (!currentPerson.friends[i].visited) {
                    nextFriendIdx = i;
                    break;
                }

            // backtrack or keep going
            if (nextFriendIdx == -1) {
                currentPerson.visited = false;
                friendDis--;
                stack.pop();
            }
            else {
                currentPerson.friends[nextFriendIdx].visited = true;
                friendDis++;
                if (friendDis == friendDistance)
                    return true;

                stack.peak().friendIdx = nextFriendIdx;
                stack.push(currentPerson.friends[nextFriendIdx], -1);
            }
        }

        return false;
    }
}

public class Baek13023 {

    public void Solution() {
        Person[] people = Inputter.getInput();
        if (people == null)
            return;

        boolean find = false;
        for (int personIdx = 0; personIdx < people.length; personIdx++) {
            find = DFSFriendLineTracer.findFriendLine(people, personIdx, 5);
            if (find)
                break;
        }

        System.out.print(find ? 1 : 0);
    }
}
