class Solution {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t == 1) return false;

        int xDiff = Math.abs(sx - fx);
        int yDiff = Math.abs(sy - fy);

        return (Math.min(xDiff, yDiff) + (Math.max(xDiff, yDiff) - Math.min(xDiff, yDiff))) <= t;
    }
}
