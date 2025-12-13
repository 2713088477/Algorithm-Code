package dp;

public class SolutionLeetCode96 {
    public boolean isInterleave1(String s1, String s2, String s3) {
    	char[] arr1=s1.toCharArray(),arr2=s2.toCharArray(),arr3=s3.toCharArray();
    	int len1=arr1.length,len2=s2.length(),len3=s3.length();
    	//由arr1[0,...,len1-1]和arr2[0,...,len2-1]能不能交错形成arr3[0,,,len1+len2-1];
    	if(len1+len2!=len3) {
    		return false;
    	}
    	boolean[][] dp=new boolean[len1+1][len2+1];
    	dp[0][0]=true;
    	for(int i=1;i<=len2;i++) {
    		if(arr2[i-1]!=arr3[i-1]) {
    			break;
    		}
    		dp[0][i]=true;
    	}
    	for(int i=1;i<=len1;i++) {
    		if(arr1[i-1]!=arr3[i-1]) {
    			break;
    		}
    		dp[i][0]=true;
    	}
    	for(int i=1;i<=len1;i++) {
    		for(int j=1;j<=len2;j++) {
    			dp[i][j]=(arr1[i-1]==arr3[i+j-1]&&dp[i-1][j])||(arr2[j-1]==arr3[i+j-1]&&dp[i][j-1]);
    		}
    	}
    	return dp[len1][len2];
    }
    //空间压缩
    public boolean isInterleave2(String s1, String s2, String s3) {
    	char[] arr1=s1.toCharArray(),arr2=s2.toCharArray(),arr3=s3.toCharArray();
    	int len1=arr1.length,len2=s2.length(),len3=s3.length();
    	//由arr1[0,...,len1-1]和arr2[0,...,len2-1]能不能交错形成arr3[0,,,len1+len2-1];
    	if(len1+len2!=len3) {
    		return false;
    	}
    	boolean[] dp=new boolean[len2+1];
    	dp[0]=true;
    	for(int i=1;i<=len2;i++) {
    		if(arr2[i-1]!=arr3[i-1]) {
    			break;
    		}
    		dp[i]=true;
    	}
    	for(int i=1;i<=len1;i++) {
    		dp[0]=(arr1[i-1]==arr3[i-1]&&dp[0]);
    		for(int j=1;j<=len2;j++) {
    			dp[j]=(arr1[i-1]==arr3[i+j-1]&&dp[j])||(arr2[j-1]==arr3[i+j-1]&&dp[j-1]);
    		}
    	}
    	return dp[len2];
    	
    }

}
