class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int carCount[] = new int[26];
        for (int ch : s.toCharArray()) {
            carCount[ch - 'a']++;
        }
        int sIndex = -1;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            carCount[ch - 'a']--;
            set.add(ch);
            if (carCount[ch - 'a'] == 0) {
                boolean allProcessed = true;
                for (char c : set) {
                    if (carCount[c - 'a'] > 0) {
                        allProcessed = false;
                        break;
                    }
                }
                if (!allProcessed) continue;
                result.add(i - sIndex);
                sIndex = i;
                set = new HashSet<>();
            }
        }
        return result;
    }
}
