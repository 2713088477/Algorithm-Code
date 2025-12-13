package dp;

public class SolutionLeetCode72 {
    public int minDistance1(String word1, String word2) {
        char[] arr1=word1.toCharArray();
        char[] arr2=word2.toCharArray();
        return findMinPrice(arr1,arr2,1,1,1);
    }
    //将arr1[0,...,len1-1]变为arr2[0,...,len2-1]所需要的最小代价
    public int findMinPrice(char[] arr1,char[] arr2,int insert,int replace,int delete) {
    	int len1=arr1.length,len2=arr2.length;
    	int[][] dp=new int[len1+1][len2+1];
    	for(int i=1;i<=len2;i++) {
    		dp[0][i]=i*insert;
    	}
    	for(int i=1;i<=len1;i++) {
    		dp[i][0]=i*delete;
    	}
    	for(int i=1;i<=len1;i++) {
    		for(int j=1;j<=len2;j++) {
    			if(arr1[i-1]==arr2[j-1]) {
    				dp[i][j]=dp[i-1][j-1];
    			}else {
    				int f1=dp[i-1][j]+delete;
    				int f2=dp[i-1][j-1]+replace;
    				int f3=dp[i-1][j-1]+delete+insert;
    				int f4=dp[i][j-1]+insert;
    				dp[i][j]=Math.min(Math.min(f1, f2), Math.min(f3, f4));
    			}
    		}
    	}
    	return dp[len1][len2];
    }
    //空间压缩
    public int minDistance2(String word1, String word2) {
        char[] arr1=word1.toCharArray();
        char[] arr2=word2.toCharArray();
        return findMinPrice(arr1,arr2,1,1,1);
    }
    //将arr1[0,...,len1-1]变为arr2[0,...,len2-1]所需要的最小代价
    public int findMinPriceWithLessMemory(char[] arr1,char[] arr2,int insert,int replace,int delete) {
    	int len1=arr1.length,len2=arr2.length;
    	int[] dp=new int[len2+1];
    	for(int i=1;i<=len2;i++) {
    		dp[i]=i*insert;
    	}
    	for(int i=1;i<=len1;i++) {
    		int leftUp=dp[0],temp;
    		dp[0]=i*delete;
    		for(int j=1;j<=len2;j++) {
    			temp=dp[j];
    			if(arr1[i-1]==arr2[j-1]) {
    				dp[j]=leftUp;
    			}else {
    				int f1=dp[j-1]+delete;
    				int f2=leftUp+replace;
    				int f3=leftUp+delete+insert;
    				int f4=dp[j]+insert;
    				dp[j]=Math.min(Math.min(f1, f2), Math.min(f3, f4));
    			}
    			leftUp=temp;
    		}
    	}
    	return dp[len2];
    }

}
