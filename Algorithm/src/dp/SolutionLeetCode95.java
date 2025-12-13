package dp;

import java.util.Arrays;

public class SolutionLeetCode95 {
	/**
	 * 暴力递归
	 * @param text1
	 * @param text2
	 * @return
	 */
    public int longestCommonSubsequence1(String text1, String text2) {
    	char[] arr1=text1.toCharArray();
    	char[] arr2=text2.toCharArray();
    	return f1(arr1,arr2,arr1.length,arr2.length);
    }
    //arr1[0,1,2,---,len1-1]与arr2[0,1,2,---,len2-1]的最长公共子序列长度
    public int f1(char[] arr1,char[] arr2,int len1,int len2) {
    	if(len1==0 || len2==0) {
    		return 0;
    	}
    	int ans;
    	if(arr1[len1-1]==arr2[len2-1]) {
    		ans = f1(arr1,arr2,len1-1,len2-1)+1;
    	}else {
    		ans = Math.max(f1(arr1,arr2,len1-1,len2), f1(arr1,arr2,len1,len2-1));
    	}
    	return ans;
    }
    /**
     * 记忆化搜索
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1,String text2) {
    	char[] arr1=text1.toCharArray();
    	char[] arr2=text2.toCharArray();
    	int len1=arr1.length,len2=arr2.length;
    	int[][] dp=new int[len1+1][len2+1];
    	for(int i=0;i<dp.length;i++) {
    		Arrays.fill(dp[i], -1);
    	}
    	return f2(arr1,arr2,len1,len2,dp);

    }
  //arr1[0,1,2,---,len1-1]与arr2[0,1,2,---,len2-1]的最长公共子序列长度
    public int f2(char[] arr1,char[] arr2,int len1,int len2,int[][] dp) {
    	if(len1==0 || len2==0) {
    		return 0;
    	}
    	if(dp[len1][len2]!=-1) {
    		return dp[len1][len2];
    	}
    	int ans;
    	if(arr1[len1-1]==arr2[len2-1]) {
    		ans = f2(arr1,arr2,len1-1,len2-1,dp)+1;
    	}else {
    		ans = Math.max(f2(arr1,arr2,len1-1,len2,dp), f2(arr1,arr2,len1,len2-1,dp));
    	}
    	dp[len1][len2]=ans;
    	return ans;
    }
    /**
     * 严格位置以来的动态规划
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence3(String text1, String text2) {
    	char[] arr1=text1.toCharArray();
    	char[] arr2=text2.toCharArray();
    	int len1=arr1.length,len2=arr2.length;
    	int[][] dp=new int[len1+1][len2+1];
    	for(int i=1;i<=len1;i++) {
    		for(int j=1;j<=len2;j++) {
    			if(arr1[i-1]==arr2[j-1]) {
    				dp[i][j]=dp[i-1][j-1]+1;
    			}else {
    				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
    	return dp[len1][len2];
    }
    /**
     * 严格位置以来的动态规划+空间压缩
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence4(String text1, String text2) {
    	char[] arr1,arr2;
    	if(text1.length()>text2.length()) {
    		arr1=text1.toCharArray();
    		arr2=text2.toCharArray();
    	}else {
    		arr1=text2.toCharArray();
    		arr2=text1.toCharArray();
    	}
    	int len=arr2.length;
    	int[] dp=new int[len+1];
    	int leftUp=0,temp;
    	for(int i=1;i<=arr1.length;i++) {
    		leftUp=0;
    		for(int j=1;j<=arr2.length;j++) {
    			if(arr1[i-1]==arr2[j-1]) {
    				temp=dp[j];
    				dp[j]=leftUp+1;
    				leftUp=temp;
    			}else {
    				leftUp=dp[j];
    				dp[j]=Math.max(dp[j-1], dp[j]);
    			}
    		}
    	}
    	return dp[arr2.length];
    }
    
}
