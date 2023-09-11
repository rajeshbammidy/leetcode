class Solution {

    /**
     */
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Pair<Integer, Integer>> list = new ArrayList();
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int n = position.length;
        for (int i = 0; i < n; i++) {
            list.add(new Pair(position[i], speed[i]));
        }
        list.sort((a, b) -> a.getKey() - b.getKey());
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(list.get(i));
            } else {
                Pair<Integer, Integer> peek = stack.peek();
                double peekTime = ((target - peek.getKey()) * 1.0) / peek.getValue();
                Pair<Integer, Integer> cur = list.get(i);
                double curTime = ((target - cur.getKey()) * 1.0) / cur.getValue();
                System.out.println(curTime);
                if (curTime > peekTime) {
                    stack.push(cur);
                }
            }
        }
        //System.out.println(stack);
        return stack.size();
    }
}
