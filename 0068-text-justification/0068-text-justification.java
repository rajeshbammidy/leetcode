class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int startIndex = i;
            sb.append(words[i]);
            int currentLen = words[i].length();
            i++;
            while (i < n && (currentLen + (words[i].length() + 1) <= maxWidth)) {
                currentLen += (words[i].length() + 1);
                i++;
            }
            // System.out.println(startIndex + " " + i);
            //if only one word
            if (i == n) {
                int spaces = maxWidth - currentLen;
                int j = startIndex + 1;
                for (; j < n; j++) {
                    sb.append(" ").append(words[j]);
                }
                for (int s = 0; s < spaces; s++) {
                    sb.append(" ");
                }
            } else if (i - startIndex == 1) {
                int spaces = maxWidth - sb.length();
                for (int s = 0; s < spaces; s++) {
                    sb.append(" ");
                }
            } else {
                int numVaccancies = i - startIndex - 1;
                System.out.println(i + " " + startIndex);
                int spaces = maxWidth - currentLen;

                int equalDist = spaces / numVaccancies;
                //System.out.println(equalDist + " " + numVaccancies);
                int remaining = spaces % numVaccancies;
                // System.out.println(i + " " + startIndex + " " + numVaccancies + " " + equalDist + " " + remaining);
                sb.append(" ");

                if (remaining > 0) {
                    sb.append(" ");
                    remaining--;
                }

                for (int s = 0; s < equalDist; s++) {
                    sb.append(" ");
                }

                for (int j = startIndex + 1; j < i; j++) {
                    sb.append(words[j]);
                    if (j != i - 1) {
                        if (remaining > 0) {
                            sb.append(" ");
                            remaining--;
                        }
                        sb.append(" ");
                        for (int s = 0; s < equalDist; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            System.out.println(sb.length());
            result.add(sb.toString());
        }
        return result;
    }
}
