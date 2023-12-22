import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Person {
    private final List<Person> primitiveFriends = new ArrayList<>();
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

    private static StackData[] stack = null;

    public static boolean findFriendLine(Person[] people, int startPerson, int friendDistance) {

        if (stack == null)
            stack = new StackData[people.length];
        int top = -1;

        // Init
        people[startPerson].visited = true;
        int friendDis = 1;
        if (stack[++top] != null) {
            stack[top].currentPerson = people[startPerson];
            stack[top].friendIdx = people[startPerson].friends.length;
        }
        else
            stack[top] = new StackData(people[startPerson], people[startPerson].friends.length);

        // DFS
        while (top != -1) {

            Person currentPerson = stack[top].currentPerson;

            // get previous friend
            int prevFriendIdx = stack[top].friendIdx - 1;
            for (; prevFriendIdx >= 0; prevFriendIdx--)
                if (!currentPerson.friends[prevFriendIdx].visited)
                    break;

            // backtrack or keep going
            if (prevFriendIdx == -1) {
                currentPerson.visited = false;
                friendDis--;
                top--;
            }
            else {
                currentPerson.friends[prevFriendIdx].visited = true;
                friendDis++;
                if (friendDis == friendDistance)
                    return true;

                stack[top].friendIdx = prevFriendIdx;

                if (stack[++top] != null) {
                    stack[top].currentPerson = currentPerson.friends[prevFriendIdx];
                    stack[top].friendIdx = currentPerson.friends[prevFriendIdx].friends.length;
                }
                else
                    stack[top] = new StackData(currentPerson.friends[prevFriendIdx], currentPerson.friends[prevFriendIdx].friends.length);
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
