package custom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class EvenIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private int prevValue;
    private boolean valueUpdatedFromHasNext;


    public EvenIterator(Iterator<Integer> iter) {
        this.iter = iter;
    }

    public static void main(String[] args) {
        int[] mas = {1, 3, 5, 15, 17, 18};
        EvenIterator iter = new EvenIterator(IntStream.of(mas).boxed().iterator());
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private int iterateToNext() throws NoSuchElementException {

        if (!iter.hasNext()) {
            throw new NoSuchElementException();
        }

        int value = iter.next();
        while (iter.hasNext() && value % 2 != 0) {
            value = iter.next();
        }

        if (value % 2 != 0) {
            throw new NoSuchElementException();
        }
        return value;
    }

    @Override
    public boolean hasNext() {
        try {
            prevValue = iterateToNext();
            valueUpdatedFromHasNext = true;
        } catch (NoSuchElementException exc) {
            return false;
        }
        return true;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!valueUpdatedFromHasNext) {
            prevValue = iterateToNext();
            valueUpdatedFromHasNext = false;
        }
        return prevValue;
    }
}
