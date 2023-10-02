class Solution {

    public boolean winnerOfGame(String colors) {
        int aliceWins = 0;
        int bobWins = 0;
        int consecACount = 0;
        int consecBCount = 0;
        for (char ch : colors.toCharArray()) {
            if (ch == 'A') {
                consecACount++;
            } else {
                if (consecACount >= 3) {
                    aliceWins += (consecACount - 2);
                }
                consecACount = 0;
            }
        }
        if (consecACount > 2) aliceWins += (consecACount - 2);
        for (char ch : colors.toCharArray()) {
            if (ch == 'B') {
                consecBCount++;
            } else {
                if (consecBCount >= 3) {
                    bobWins += (consecBCount - 2);
                }
                consecBCount = 0;
            }
        }
        if (consecBCount > 2) bobWins += (consecBCount - 2);

        System.out.println(aliceWins + " " + bobWins);
        //if (aliceWins > 0 && aliceWins == bobWins) return false;
        return aliceWins > 0 && aliceWins > bobWins;
    }
}
