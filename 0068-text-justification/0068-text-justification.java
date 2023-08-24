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
            // add the elements till the length is < maxWidth
            while (i < n && (currentLen + (words[i].length() + 1) <= maxWidth)) {
                currentLen += (words[i].length() + 1);
                i++;
            }

            // if it is the last line, make it left justiefied
            if (i == n) {
                //find the number of space we have to append
                int spaces = maxWidth - currentLen;
                int j = startIndex + 1;
                for (; j < n; j++) {
                    sb.append(" ").append(words[j]);
                }
                for (int s = 0; s < spaces; s++) {
                    sb.append(" ");
                }
            } else if (i - startIndex == 1) {
                // if it is the only element in the line add the remaning spaces.
                int spaces = maxWidth - sb.length();
                for (int s = 0; s < spaces; s++) {
                    sb.append(" ");
                }
            } else {
                //find the number of gaps
                int numVaccancies = i - startIndex - 1;
                // find the number of spaces
                int spaces = maxWidth - currentLen;
                // find how many space we have to fill in each gap
                int equalDist = spaces / numVaccancies;
                // find the remaining spaces aka not equally distrubuted spaces
                int remaining = spaces % numVaccancies;
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
            result.add(sb.toString());
        }
        return result;
    }
}
