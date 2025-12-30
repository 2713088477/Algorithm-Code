package LeetCodeDaily;

import java.util.HashSet;
import java.util.Set;

public class Solution_840 {
    //暴力尝试
    private int row;
    private int column;
    public int numMagicSquaresInside(int[][] grid) {
        row=grid.length;
        column=grid[0].length;
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(i+2<row && j+2<column){
                    if(grid[i+1][j+1]!=5)continue;
                
                    Set<Integer> set=new HashSet<>();
                    for(int r=i;r<i+3;r++){
                        for(int c=j;c<j+3;c++){
                            set.add(grid[r][c]);

                        }
                    }
                    int len=1;
                    for(len=1;len<=9;len++){
                        if(!set.contains(len))break;
                    }
                    if(len==10){
                        int r1=grid[i][j]+grid[i][j+1]+grid[i][j+2];
                        int r2=grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
                        int c1=grid[i][j]+grid[i+1][j]+grid[i+2][j];
                        int c2=grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
                        if(r1==15&&r2==15&&c1==15&&c2==15)ans++;
                    }
                }
                
            }
        }
        return ans;
    }
    
	
}
