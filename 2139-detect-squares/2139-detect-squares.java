class DetectSquares {
    /**
    * Intution square diagonal has the following property
        Math.abs(x1-x2)==Math.abs(y1-y2);
        in this approach we will find the diagonal point and we will find the other cordinates using that.
    
     */
    ArrayList<int[]> cords;
    HashMap<String, Integer> cordFreq;

    public DetectSquares() {
        cords = new ArrayList<>();
        cordFreq = new HashMap<>();
    }

    public void add(int[] point) {
        cords.add(point);
        String key = point[0] + "#" + point[1];
        cordFreq.putIfAbsent(key, 0);
        cordFreq.put(key, cordFreq.get(key) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int sum = 0;
        for (int cord[] : cords) {
            int px = cord[0], py = cord[1];
            if (px == x || py == y || (Math.abs(px - x) != Math.abs(py - y))) continue;
            sum += (cordFreq.getOrDefault(px + "#" + y, 0) * cordFreq.getOrDefault(x + "#" + py, 0));
        }
        return sum;
    }
}
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
