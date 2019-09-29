import java.util.Arrays;

/**
 * Created by Admin on 11.07.19.
 */
public class IntLinkedList implements IntList, IntQueue, IntStack {
    private static class Entry {
        int value;
        IntLinkedList.Entry previous;
        IntLinkedList.Entry next;

        public Entry(int value) {
            this.value = value;
        }
    }

    public int size = 0;
    private IntLinkedList.Entry first = null;
    private IntLinkedList.Entry last = null;

    @Override
    //Used in IntQueue and IntList
    public void add(int element) {
        Entry newEntry = new Entry(element);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.previous = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    //For IntList return removed value
    public boolean remove(int index) {
        Entry tmp = first;
        boolean answer = false;
        if (index < 0 || index >= size) {
            System.out.println("Incorrect index");
            return false;
        } else if (index == 0) {
            first = first.next;
            first.previous = null;
            size--;
            answer = true;
        } else if (index == size - 1) {
            last = last.previous;
            last.next = null;
            size--;
            answer = true;
        } else {

            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            Entry left = tmp.previous;
            Entry right = tmp.next;
            left.next = right;
            right.previous = left;
            size--;
            answer = true;
        }

        return answer;
    }


    @Override
    public boolean add(int index, int element) {
        boolean answer = false;
        Entry tmp = null;
        Entry newEntry = new Entry(element);
        Entry rightElement = null;
        Entry leftElement = null;
        if (size == 0) {
            add(element);
            answer = true;
            return answer;
        } else if (index < 0 || index > size - 1) {
            System.out.println("Index out of bounds");
            return answer;
        } else if (index == size - 1) {
            add(element);
            answer = true;
        } else if (index == 0) {
            newEntry.next = first;
            newEntry.previous = null;
            first = newEntry;
            size++;
            answer = true;
        } else {
            tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            leftElement = tmp;
            rightElement = tmp.next;
            newEntry.previous = leftElement;
            newEntry.next = rightElement;
            leftElement.next = newEntry;
            rightElement.previous = newEntry;
            size++;
            answer = true;
        }
        return answer;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;

    }

    @Override
    public int get(int index) {
        Entry tmp = first;
        if (index < 0 || index >= size) {
            System.out.println("Incorrect number");
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }


    @Override
    public boolean removeByValue(int value) {
        Entry tmp = first;
        int index = 0;
        boolean answer = false;
        do {
            if (tmp.value == value) {
                remove(index);
                answer = true;
            } else {
                index++;
            }
            tmp = tmp.next;
        } while (index < size);

        return answer;
    }

    @Override
    public boolean set(int index, int element) {
        boolean answer;
        Entry tmp = first;
        if (index < 0 || index > size) {
            System.out.println("Incorrect index");
            answer = false;
            return answer;
        }

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.value = element;
        answer = true;
        return answer;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        //возвращает элемнты включительно по указанные индексы

        IntList answer = new IntLinkedList();
        int i = 0;
        Entry tmp = first;
        if (fromIndex < 0 || fromIndex > size - 1) {
            System.out.println("fromIndex out of bounds");
            return null;
        } else if (toIndex < 0 || toIndex > size - 1) {
            System.out.println("toIndex out of bounds");
            return null;
        } else {
            for (i = 0; i <= toIndex; i++) {
                if (i < fromIndex) {
                    tmp = tmp.next;
                } else {
                    answer.add(get(i));
                }
            }
        }
        return answer;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmpEntry = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmpEntry.value;
            tmpEntry = tmpEntry.next;
        }

        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

//IntStack methods

    @Override
    public boolean push(int value) {
        boolean answer = false;
        Entry tmp = new Entry(value);
        if (size == 0) {
            first = tmp;
            last = tmp;
            first.previous = null;
            last.next = null;
        } else {
            first.previous = tmp;
            tmp.next = first;
            tmp.previous = null;
            first = tmp;
        }
        size++;
        answer = true;
        return answer;
    }

    @Override
    public int pop() {
        int answer;
        if (size == 0) {
            System.out.println("Stack is empty.. return zero");
            answer = 0;
        } else {
            answer = first.value;

            first = first.next;
            size--;
        }

        return answer;
    }

    @Override
    public int peek() {
        return first.value;
    }

//IntQueue methods

    @Override
    public int element() {
        return first.value;
    }

    @Override
    //For IntQueue return removed value
    public int remove() {
        int answer = first.value;
        remove(0);
        return answer;
    }

}
