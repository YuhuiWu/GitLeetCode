/*
 *The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
 *The dungeon consists of M x N rooms laid out in a 2D grid. 
 *Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 *The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *Notes:
 *The knight's health has no upper bound.
 *Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DP_174_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[] dp=new int[m][n];
        //Initialize
        dp[m-1][n-1]=Math.max(0-dungeon[m-1][n-1],0);
        for(int i = m-2; i >= 0; i--){
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1], 0);
        }
        for(int i = n-2; i >= 0; i--){
            dp[m-1][i] = Math.max(dp[m-1][i+1] - dungeon[m-1][i], 0);
        }
        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[i][j] = Math.max(Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j], 0);
            }
        }
        return dp[0][0] + 1;
    }
}