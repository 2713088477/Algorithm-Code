package dp;

public class SolutionLeetCode115 {
	//暴力尝试
    public int numDistinct1(String s, String t) {
        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        return findMax(sArr,tArr,sArr.length,tArr.length);
    }
    //sArr[0,...,sLen-1]中有多少个子序列 == tArr[0,...,tLen-1]
    public int findMax(char[] sArr,char[] tArr,int sLen,int tLen) {
    	if(sLen==0&&tLen==0) return 1;
    	if(sLen==0) return 0;
    	if(tLen==0) return 1;
    	int ans=findMax(sArr,tArr,sLen-1,tLen);
    	if(sArr[sLen-1]==tArr[tLen-1]) {
    		ans+=findMax(sArr,tArr,sLen-1,tLen-1);
    	}
    	return ans;
    }
    
    
    //严格位置依赖
    public int numDistinct2(String s, String t) {
        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        return findMaxByPos(sArr,tArr);
    }
    //sArr[0,...,sLen-1]中有多少个子序列 == tArr[0,...,tLen-1]
    public int findMaxByPos(char[] sArr,char[] tArr) {
    	int slen=sArr.length,tlen=tArr.length;
    	int[][] dp=new int[slen+1][tlen+1];
    	for(int i=1;i<dp[0].length;i++) {
    		dp[0][i]=0;
    	}
    	for(int i=0;i<dp.length;i++) {
    		dp[i][0]=1;
    	}
    	for(int i=1;i<dp.length;i++) {
    		for(int j=1;j<dp[0].length;j++) {
    			dp[i][j]=dp[i-1][j];
    			if(sArr[i-1]==tArr[j-1]) {
    				dp[i][j]+=dp[i-1][j-1];
    			}
    		}
    	}
    	return dp[slen][tlen];
    }
    
    //空间压缩
    public int numDistinct3(String s, String t) {
        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        return findMaxByPosWithLessMemory(sArr,tArr);
    }
    //sArr[0,...,sLen-1]中有多少个子序列 == tArr[0,...,tLen-1]
    public int findMaxByPosWithLessMemory(char[] sArr,char[] tArr) {
    	int slen=sArr.length,tlen=tArr.length;
    	int[]dp=new int[tlen+1];
    	dp[0]=1;
    	for(int i=1;i<=slen;i++) {
    		for(int j=tlen;j>=1;j--) {
    			if(sArr[i-1]==tArr[j-1]) {
    				dp[j]+=dp[j-1];
    			}
    		}
    	}
    	return dp[tlen];
    }
}
