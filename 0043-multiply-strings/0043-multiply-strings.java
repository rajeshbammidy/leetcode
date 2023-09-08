class Solution {

    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int dp[] = new int[num1.length() + num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            for (int j = 0; j < num1.length(); j++) {
                int a = num2.charAt(i) - '0';
                int b = num1.charAt(j) - '0';
                int mulValue = a * b;
                mulValue += dp[i + j];
                int carry = mulValue / 10;
                int cd = mulValue % 10;
                dp[i + j] = cd;
                dp[i + j + 1] += carry;
            }
            //System.out.println(Arrays.toString(dp));
        }
        int i = dp.length - 1;
        while (i >= 0 && dp[i] == 0) i--;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            sb.append(dp[i] + "");
            i--;
        }
        if (sb.toString().isEmpty()) return "0";
        return sb.toString();
    }
}
