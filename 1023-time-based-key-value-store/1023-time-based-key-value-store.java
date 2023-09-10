class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        // ArrayList<Integer> list = new ArrayList<>(map.get(key).keySet());
        // int beg = 0;
        // int end = list.size() - 1;
        // while (beg <= end) {
        //     int mid = beg + (end - beg) / 2;
        //     if (list.get(mid) > timestamp) end = mid - 1; else beg = mid + 1;
        // }
        // beg -= 1;
        // if (beg < 0) return "";
        // return map.get(key).get(list.get(beg));
        Integer fkey = map.get(key).floorKey(timestamp);
        if (fkey == null) return "";
        return map.get(key).get(fkey);
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
