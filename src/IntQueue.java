/**
 * Created by Admin on 10.07.19.
 */
public interface IntQueue {
    void add(int value);

    int remove(); // return first in Queue but and remove it

    int element(); // return first in Queue but not remove it
}
