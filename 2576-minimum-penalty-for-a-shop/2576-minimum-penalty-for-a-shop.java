class Solution {

    public int bestClosingTime(String customers) {
        System.out.println(customers.length());
        if (customers.replaceAll("N", "").isEmpty() || customers.isEmpty()) return 0;
        System.out.println(customers.length());
        int n = customers.length();

        int leftY[] = new int[n];
        int rightY[] = new int[n];
        if (customers.charAt(0) == 'Y') leftY[0] = 1;
        if (customers.charAt(n - 1) == 'Y') rightY[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                leftY[i] = 1 + leftY[i - 1];
            } else {
                leftY[i] = leftY[i - 1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                rightY[i] = 1 + rightY[i + 1];
            } else {
                rightY[i] = rightY[i + 1];
            }
        }
        
        int min = Integer.MAX_VALUE;
        int hour = 0;

        for (int i = 0; i < n; i++) {
            char ch = customers.charAt(i);
            int nOnLeft = i == 0 ? 0 : i - leftY[i - 1];
            int yOnRight = i == n - 1 ? 0 : rightY[i + 1];
            int penalty = 0;
            if (ch == 'Y') {
                penalty = 1;
            }
            penalty += (nOnLeft + yOnRight);
            if (min > penalty) {
                min = penalty;
                hour = i;
            }
        }

        int nOnLeft = n - leftY[n - 1];
        if (nOnLeft < min) {
            min = nOnLeft;
            hour = n;
        }
        return hour;
    }
}
