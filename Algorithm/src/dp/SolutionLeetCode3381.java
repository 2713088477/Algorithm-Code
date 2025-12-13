package dp;

import java.io.File;
import java.io.PrintStream;

public class SolutionLeetCode3381 {
	public long maxSubarraySum1(int[] nums, int k) {
        //暴力做法
        int len=nums.length;
        int windowLen=k;
        long ans=Long.MIN_VALUE;
        while(windowLen<=len){
            //System.out.println("当前窗口长度:"+windowLen);
            long sum=0;
            for(int i=0;i<len;i++){
                if(i+1-windowLen<0){
                    sum+=nums[i];
                    //System.out.println("还未进入窗口,sum:"+sum);
                    continue;
                }
                sum+=nums[i];
                //System.out.println("进入了窗口,sum:"+sum);
                ans=Math.max(ans,sum);
                sum-=nums[i+1-windowLen];
            }
            windowLen=windowLen+k;
        }
        return ans;
    }
	public long maxSubarraySum2(int[] nums, int k) {
		int len=nums.length;
        int[][] dp=new int[len+1][k+1];
        //初始化
        for(int i=1;i<=len;i++) {
        	dp[i][1]=Math.max(dp[i-1][1], dp[i-1][1]+nums[i-1]);
        }
        for(int i=1;i<=len;i++) {
        	for(int j=2;j<=k;j++) {
        		dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1]+nums[i-1]);
        	}
        }
        return dp[len][k];
    }
	public static void main(String[] args) throws Exception {
		PrintStream fileOut=new PrintStream(new File("output.txt"));
		System.setOut(fileOut);
		
	}
}
