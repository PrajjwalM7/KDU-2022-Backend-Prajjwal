import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Stack<E> {
    List<E> val;

    Stack() {
        val = new ArrayList<E>();
    }

    public void push(E e) {
        val.add(e);
    }

    public E pop() {
        E e = null;
        if (val.size() == 0) {
            System.out.println("Empty Stack!");
        } else {
            e = val.get(val.size() - 1);
            val.remove(val.size() - 1);
        }
        return e;
    }

    public E peek() {
        E e = null;
        if (val.size() == 0) {
            System.out.println("Empty Stack!");
        } else {
            e = val.get(val.size() - 1);
        }
        return e;
    }

    public void print() {
        for (E e : val) {
            System.out.println(e.toString());
        }
    }
}

public class HW_3_Q_3 {

    public static List<Stack> sortTopElement(List<Stack> l) {
        Collections.sort(l, new Comparator<Stack>() {
            @Override
            public int compare(Stack o1, Stack o2) {
                return o1.peek().toString().compareTo(o2.peek().toString()) >= 0 ? 1 : -1;
            }
        });
        return l;
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(1);
        s1.push(2);
        s1.push(9);
        s1.push(6);
        s1.push(7);

        Stack<Integer> s2 = new Stack<Integer>();
        s2.push(10);
        s2.push(12);
        s2.push(9);
        s2.push(61);
        s2.push(45);

        List<Stack> stks = new ArrayList<Stack>();
        stks.add(s1);
        stks.add(s2);

        stks = sortTopElement(stks);
        System.out.println("Stacks after sorting by top elements : ");
        for(Stack s : stks) {
            System.out.println(s.peek());
        }
    }
}
