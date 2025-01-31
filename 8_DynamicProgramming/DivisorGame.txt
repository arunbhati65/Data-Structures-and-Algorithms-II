/*
Alice and Bob take turns playing a game, with Alice starting first.
Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.
Return True if and only if Alice wins the game, assuming both players play optimally.
 */
// Java program for implementation of
// optimal strategy for the divisor
// game using dynamic programming

public class DivisorGame {

    public static boolean divisorGame(int N) {
        Boolean[] memo =new Boolean[N+1];
        return canWin(N,memo);
    }

    static boolean canWin(int N,Boolean[] memo) {
        if(memo[N]!=null)return memo[N];
        if (N <= 1)
            return memo[N]=false;
        for (int i = 1; i * i <= N && N%i==0; i++) {
            if(!canWin(N-i,memo)){
                return memo[N]=true;
            }
        }
        return memo[N]=false;
    }

    public static void main(String[] args) {
        int N = 3;
        if (divisorGame(N))
            System.out.print("yes you can");
        else
            System.out.print("other will win");
    }
}

