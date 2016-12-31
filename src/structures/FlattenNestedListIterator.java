package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuanwang on 12/30/16.
 */
public class FlattenNestedListIterator {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

    public class NestedInteger{
        public Integer getInteger(){
            return 0;
        }

        public boolean isInteger(){
            return true;
        }

        public NestedInteger getList(){
            return this;
        }

        public int size(){
            return 0;
        }

        public NestedInteger get(int i){
            return this;
        }
    }

    public class NestedIterator implements Iterator<Integer> {
        LinkedList<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            for(int i = nestedList.size()-1; i >=0; i--){
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()){
                if(stack.peek().isInteger()){
                    return true;
                }
                NestedInteger cur = stack.pop();
                for(int i = cur.getList().size()-1; i >= 0; i--){
                    stack.push(cur.getList().get(i));
                }
            }
            return false;

        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
