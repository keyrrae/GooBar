package structures;

import java.util.Iterator;

/**
 * Created by xuanwang on 1/1/17.
 */
public class PeekingIterator  implements  Iterator<Integer>{
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    Integer next = null;
    Iterator<Integer> it;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;

        if(it.hasNext()){
            next = it.next();
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = next;
        next = it.hasNext() ? it.next() : null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

}
