package dp;

public class SolutionLeetCode516 {
	//暴力递归
    public int longestPalindromeSubseq1(String s) {
        char[] arr=s.toCharArray();
        return findMax1(arr,0,arr.length-1);
    }
    //arr[left,right]中的最长回文串的个数
    public int findMax1(char[] arr,int left,int right) {
    	if(left==right) return 1;
    	if(left+1==right) return arr[left]==arr[right]?2:1;
    	int ans=1;
    	if(arr[left]==arr[right]) {
    		ans=findMax1(arr,left+1,right-1)+2;
    	}else {
    		ans=Math.max(findMax1(arr,left+1,right), findMax1(arr,left,right-1));
    	}
    	return ans;
    }
    
    //纯粹的位置依赖
    public int longestPalindromeSubseq2(String s) {
        char[] arr=s.toCharArray();
        return findMax2(arr);
    }
    //arr[left,right]中的最长回文串的个数
    public int findMax2(char[] arr) {
    	int len=arr.length;
    	int[][] dp=new int[len][len];
    	for(int i=0;i<len;i++) {
    		dp[i][i]=1;
    	}
    	for(int i=len-1;i>=0;i--) {
    		if(i+1<len) {
    			dp[i][i+1]=arr[i]==arr[i+1]?2:1;
    		}
    		for(int j=i+2;j<len;j++) {
    			if(arr[i]==arr[j]) {
    				dp[i][j]=dp[i+1][j-1]+2;
    			}else {
    				dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
    			}
    		}
    	}
    	return dp[0][len-1];
    }
    
    //纯粹的位置依赖+空间压缩
    public int longestPalindromeSubseq3(String s) {
        char[] arr=s.toCharArray();
        return findMax3(arr);
    }
    //arr[left,right]中的最长回文串的个数
    public int findMax3(char[] arr) {
    	int len=arr.length;
    	int[] dp=new int[len];
    	int leftDown=1,temp;
    	for(int i=len-1;i>=0;i--) {
    		dp[i]=1;
    		if(i+1<len) {
    			dp[i+1]=arr[i]==arr[i+1]?2:1;
    		}
    		leftDown=1;
    		for(int j=i+2;j<len;j++) {
    			temp=dp[j];
    			if(arr[i]==arr[j]) {
    				dp[j]=leftDown+2;
    			}else{
    				dp[j]=Math.max(dp[j-1], dp[j]);
    			}
    			leftDown=temp;
    		}
    	}
    	return dp[len-1];
    }
    
}
