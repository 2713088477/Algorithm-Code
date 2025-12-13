package dpDay2;

public class SolutionLeetCode32 {
    public int longestValidParentheses(String s) {
    	char[] arr = s.toCharArray();
    	int[] dp = new int[s.length()];
    	int ans=0;
    	for(int i=1,p;i<s.length();i++) {
    		if(arr[i]==')') {
    			p=i-dp[i-1]-1;
        		if(p>=0&&arr[p]=='(') {
        			dp[i]=dp[i-1]+2+(p>0?dp[p-1]:0);
        		}
    		}
    		ans=Math.max(ans, dp[i]);
    	}
    	return ans;
    }
}
