class Solution {

    /**
    * There are n-cars going in a single lane and it is given that a car never can never pass the car before it.
    To get the exact view sort the positions array and attach its speeds.
    a car i can go match to car at (i+1) only if the time taken by the car at i is less than the time taken by the car at (i+1).If they can match the car at i reach to car at (i+1) and moves with the same speed. Now the car at i-2 has to check if it can match i+1 or not.
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
        return stack.size();
    }
}
