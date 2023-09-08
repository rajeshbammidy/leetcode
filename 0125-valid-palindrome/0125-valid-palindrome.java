class Solution {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                sb.append(ch);
            }
        }

        return sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase());
    }
}
