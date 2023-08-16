class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        int i = 0;
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        while (i < k) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            i++;
        }
        ans[index++] = nums[deque.getFirst()];

        while (i <= n - 1) {
            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.add(i);
            ans[index++] = nums[deque.getFirst()];
            i++;
        }
        return ans;
    }
}
