class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for (String word : wordList) {
            words.add(word);
        }
        visited.add(beginWord);
        if (!words.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return distance;
                StringBuilder sb = new StringBuilder(cur);
                for (int c = 0; c < cur.length(); c++) {
                    char orgCh = cur.charAt(c);
                    for (int j = 0; j < 26; j++) {
                        char ch = (char) ('a' + j);
                        sb.replace(c, c + 1, ch + "");
                        if (words.contains(sb.toString()) && !visited.contains(sb.toString())) {
                            visited.add(sb.toString());
                            queue.add(sb.toString());
                        }
                    }
                    sb.replace(c, c + 1, orgCh + "");
                }
            }
        }
        return 0;
    }
}
