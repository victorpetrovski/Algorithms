package com.victor.bitmanipulation;

/**
 * Created by Victor on 12/21/17.
 * <p>
 * // Louise and Richard play a game. They have a counter set to N.In every game, Louise gets the first turn and the turns alternate thereafter. In the game, they perform the following operations.
 * //
 * // If N is not a power of 2, reduce the counter by the largest power of 2 less than N.
 * // If N is a power of 2, reduce the counter by half of N.
 * // The resultant value is the new  which is again used for subsequent operations.
 * // The game ends when the counter reduces to 1, i.e., N == 1 , and the last person to make a valid move wins.
 * //
 * // Given N, your task is to find the winner of the game.
 */
public class CounterGamePowerOfTwo {

    private final static String first_player = "Louise";
    private final static String second_player = "Richard";


    public void playGame(long N) {

        String playerMoves = first_player;
        while (N >= 1) {
            if (!isPowerOfTwo(N)) {
                N -= largestPowerOf2(N);
            } else if (isPowerOfTwo(N)) {
                N /= 2;
            }

            //it's the next player turn
            playerMoves = switchPlayer(playerMoves);
        }
        System.out.println(playerMoves);
    }

    private String switchPlayer(String currentPlayer) {
        return currentPlayer.equals(first_player) ? second_player : first_player;
    }

    /**
     * Bitwise shifting function to find if the number is power of two
     * The number is power of two if only have one bit '1' and all bits to the right are zeros
     * <p>
     * 2^2 = 0 0 0 0 0 0 1 0 0 0 = 4
     * 2^3 = 0 0 0 0 0 1 0 0 0 0 = 8
     * 2^4 = 0 0 0 0 1 0 0 0 0 0 = 16
     * 2^5 = 0 0 0 1 0 0 0 0 0 0 = 32
     * 2^6 = 0 0 1 0 0 0 0 0 0 0 = 64
     * <p>
     * (N-1) in bit representation should have all the places that are 0 to 1 and the 1 to 0.
     * That is why when we perform & operation on "(N & N - 1)" we should get 0
     */
    private boolean isPowerOfTwo(long N) {
        return (N & N - 1) == 0;
    }


    /**
     * The while will keep on going until n is a power of 2,
     * in which case n will only have 1 bit on which is the maximum power of 2 less than n.
     * we will then perform the bitwise operation AND with n and n-1 to eliminate the least significant bit of n
     */

    public long largestPowerOf2(long n) {
        while (!isPowerOfTwo(n))
            n = n & n - 1;
        return n;
    }
}
