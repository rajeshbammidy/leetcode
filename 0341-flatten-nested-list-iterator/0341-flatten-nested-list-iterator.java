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
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> auxList;
    int auxI = 0;
    Queue<Integer> queue;
    int size;

    ArrayDeque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new ArrayDeque<>();
        for (NestedInteger x : nestedList) deque.addLast(x);
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        NestedInteger peek = deque.peekFirst();
        if (peek.isInteger()) {
            deque.pollFirst();
            return peek.getInteger();
        }
        //  if (!deque.isEmpty()) return deque.pollFirst().getInteger();
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!deque.isEmpty() && !deque.peekFirst().isInteger()) {
            List<NestedInteger> list = deque.pollFirst().getList();
            if (list.isEmpty()) continue;
            for (int i = list.size() - 1; i >= 0; i--) {
                deque.addFirst(list.get(i));
            }
        }
        return !deque.isEmpty();
    }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
