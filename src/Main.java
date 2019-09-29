import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
    Написать интерфейс IntList и его реализацию IntLinkedList,
    который также должен реализовывать интерфейсы IntQueue и IntStack.
    */

    static void endOfTest() {
        System.out.println("End of task... \nPress Enter");
        Scanner voidscan = new Scanner(System.in);
        String myString = voidscan.nextLine();
    }

    public static void main(String[] args) {
        IntList myList = new IntLinkedList();

// Test method ADD

        System.out.println("Test method ADD: ...");
        for (int i = 0; i < 10; i++) myList.add(i * 10);
        System.out.println(myList);
        endOfTest();


// Test methods size, clear, isEmpty

        System.out.println("Test methods size, clear, isEmpty");
        System.out.println("myList size is: " + myList.size());
        System.out.println("Does it empty?:  " + myList.isEmpty());
        System.out.println("Lets clear it...");
        myList.clear();
        System.out.println(myList);
        System.out.println("myList size is: " + myList.size());
        System.out.println("Does it empty?:  " + myList.isEmpty());
        endOfTest();

//Test method Get (int index)

        System.out.println("Restore myList... \n");
        for (int i = 0; i < 10; i++) myList.add(i * 10 + 1);
        System.out.println(myList);
        System.out.println("Now it contain " + myList.size() + " elements.\n" + "Enter number of element you want to Get: ");
        Scanner voidscan = new Scanner(System.in);
        int elementNumber = voidscan.nextInt();
        System.out.println("You will get " + elementNumber + " element of list");
        System.out.println(myList.get(elementNumber));
        endOfTest();


// Test method Set

        int a = myList.size() * 2 / 3;
        System.out.println("Test method Set. Lets set element " + a + " as 555");
        System.out.println("Does it work?:   " + myList.set(a, 555));
        System.out.println(myList);
        System.out.println("Lets set 1st element value as 0, and last element value as 1000. Does it work?...\n" + myList.set(0, 0));
        System.out.println(myList.set(myList.size() - 1, 1000));
        System.out.println("Lets set 555 at out of bound");
        a = myList.size() + 5;
        System.out.println("Does it work?:   " + myList.set(a, 555));
        System.out.println(myList);
        endOfTest();

// Test method remove(int index)

        System.out.println("Test method remove(index)...\n");
        System.out.println(myList);
        System.out.println("Removing 1st element. Does it work? ...\n" + myList.remove(0));
        System.out.println(myList);
        System.out.println("Removing last element. Does it work? ...\n" + myList.remove(myList.size() - 1));
        System.out.println(myList);
        System.out.println("Enter element index you want to remove...\n");
        elementNumber = voidscan.nextInt();
        System.out.println("Removing element:" + elementNumber + " Does it work? ...\n" + myList.remove(elementNumber));
        System.out.println(myList);
        endOfTest();

//Test boolean Add

        System.out.println("Test boolean ADD ...\n");
        System.out.println(myList);
        System.out.println("Adding 1st element with value 111. Does it work? ...\n" + myList.add(0, 111));
        System.out.println(myList);
        System.out.println("index of last element is: " + (myList.size() - 1));
        System.out.println("Adding last element with value 333. Does it work? ...\n" + myList.add((myList.size() - 1), 333));
        System.out.println(myList);
        System.out.println("Enter element index you want to add, with value 999...\n");
        voidscan = new Scanner(System.in);
        int elementIndex = voidscan.nextInt();
        System.out.println("You are adding 999 to index " + elementIndex);
        System.out.println("ADDing element:" + elementIndex + " Does it work? ...\n" + myList.add(elementIndex, 999));
        System.out.println(myList);
        System.out.println("Adding element with value -1000, before the index. Does it work? ...\n" + myList.add(-1, -1000));
        System.out.println(myList);
        System.out.println("Adding element with value 100 000, after the index. Does it work? ...\n" + myList.add(myList.size() + 1, 100000));
        System.out.println(myList);
        endOfTest();


        //Test boolean removeByValue

        System.out.println("Test boolean removeByValue ...\n");
        System.out.println(myList);
        System.out.println("Add 444 to the start, middle and to the end of List");
        myList.add(0, 444);
        myList.add((myList.size() - 1) / 2, 444);
        myList.add((myList.size() - 1), 444);
        System.out.println(myList);
        System.out.println("Lets remove by value 444, does it work?:...  " + myList.removeByValue(444));
        System.out.println(myList);
        System.out.println("Lets remove by value 999999, does it work?:...  " + myList.removeByValue(999999));
        System.out.println(myList);
        endOfTest();


// Test sublist + toArray
        System.out.println("Start test subList and toArray...\nReturn subList from 2 to 5 and convert it to Array");

        int[] result = myList.subList(2, 5).toArray();

        System.out.println(Arrays.toString(result));
        endOfTest();


        //Test Queue;
        IntQueue myQueue = new IntLinkedList();
        System.out.println("Start test Queue\nMake Queue of 10 elements...");
        for (int i = 0; i < 10; i++) {
            myQueue.add(i * 11);
        }
        System.out.println(myQueue.toString());
        endOfTest();

        System.out.println("Test Remove...");
        int tmp = myQueue.remove();
        System.out.println("tmp=" + tmp);
        System.out.println(myQueue.toString() + "\n");
        endOfTest();

        System.out.println("Test Element...");
        int tmp2 = myQueue.element();
        System.out.println("tmp2=" + tmp2);
        System.out.println(myQueue.toString() + "\n");
        endOfTest();

        // Start test stack

        System.out.println("Start test stack...\nLets make Stack from 1 to 5\nThis testing push and peek methods");
        IntStack myStack = new IntLinkedList();
        for (int i = 0; i <= 5; i++) {
            System.out.println("Does it work?..." + myStack.push(i) + ": pushed value =" + myStack.peek() + ": stack to string =\n" + myStack.toString());
            // System.out.println(myStack.toArray().toString());
        }

        endOfTest();

        System.out.println("Start test pop method");
        for (int i = 0; i <= 5; i++) {
            System.out.println(myStack.pop());
            System.out.println(myStack.toString());
        }
        System.out.println("Stack has not consist any value. By the way lets pop another one");
        System.out.println(myStack.pop());
        endOfTest();
    }
}
