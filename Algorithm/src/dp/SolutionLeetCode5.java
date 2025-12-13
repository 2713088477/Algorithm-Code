package dp;

public class SolutionLeetCode5 {
	//1是暴力方法求解最长回文字串
    public String longestPalindrome1(String s) {
    	int maxLen=0;
    	String ans="";
    	//找到arr中的最长回文数长度
        for(int i=0;i<s.length();i++) {
        	for(int j=i;j<s.length();j++) {
        		String t=s.substring(i,j+1);
        		if(isCircleString(t)&&maxLen<t.length()) {
        			ans=t;
                    maxLen=t.length();
        		}
        	}
        }
        return ans;
        
    }
    public boolean isCircleString(String s) {
    	char[] arr=s.toCharArray();
    	int left=0,right=arr.length-1;
    	while(left<right) {
    		if(arr[left]!=arr[right]) {
    			return false;
    		}
    		left++;
    		right--;
    	}
    	return true;
    	
    }
    //2.尝试改为动态规划
    public String longestPalindrome2(String s) {
    	char[] arr=s.toCharArray();
    	int len=arr.length;
    	//dp[i][j]表示arr[i]到arr[j]之间是否是回文串
    	boolean[][] dp=new boolean[len][len];
    	for(int i=len-1;i>=0;i--) {
    		dp[i][i]=true;
    		if(i+1<len) {
    			dp[i][i+1]=arr[i]==arr[i+1]?true:false;
    		}
    		
    		for(int j=i+2;j<len;j++) {
    			if(arr[i]==arr[j]) {
    	    		dp[i][j]=dp[i+1][j-1];
    	    	}else {
    	    		dp[i][j]=false;
    	    	}
    		}
    	}
    	int maxLen=0;
    	String ans="";
    	for(int i=0;i<len;i++) {
    		for(int j=0;j<len;j++) {
    			if(dp[i][j] && j-i+1>maxLen) {
    				maxLen=j-i+1;
    				ans=s.substring(i,j+1);
    			}
    		}
    	}
    	return ans;
    	
        
    }
    
    
}
