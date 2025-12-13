package dpDay2;

import java.util.Arrays;

public class SolutionLeetCode639 {
	public static final int esp=(int)1e9+7;
    public int numDecodings(String s) {
//        return violentNumDecoding(s,0);
    	long[] dp = new long[s.length()];
    	Arrays.fill(dp, -1);
    	return (int)(violentNumDecodingWithDp(s,0,dp));
    	
    	
    }
    public int violentNumDecoding(String s,int cur) {
    	if(cur==s.length()) {
    		return 1;
    	}
    	if(s.charAt(cur)=='0') {
    		return 0;
    	}
    	int ans = violentNumDecoding(s,cur+1)*(s.charAt(cur)=='*'?9:1);
    	if(s.charAt(cur)=='*') {
    		if(cur+1<s.length()&&s.charAt(cur+1)!='*') {
    			if(s.charAt(cur+1)<='6') {
    				ans+=2*violentNumDecoding(s,cur+2);
    			}else {
    				ans+=violentNumDecoding(s,cur+2);
    			}
    		}else if(cur+1<s.length()&&s.charAt(cur+1)=='*') {
    			ans+=15*violentNumDecoding(s,cur+2);
    		}
    	}else {
    		if(cur+1<s.length()&&s.charAt(cur+1)!='*') {
    			if((s.charAt(cur)-'0')*10+(s.charAt(cur+1)-'0')<=26) {
    				ans+=violentNumDecoding(s,cur+2);
    			}
    		}else if(cur+1<s.length()&&s.charAt(cur+1)=='*') {
    			if(s.charAt(cur)=='1') {
    				ans+=9*violentNumDecoding(s,cur+2);
    			}else if(s.charAt(cur)=='2') {
    				ans+=6*violentNumDecoding(s,cur+2);
    			}
    		}
    	}
    	return ans;
    }
    public long violentNumDecodingWithDp(String s,int cur,long[] dp) {
    	if(cur==s.length()) {
    		return 1;
    	}
    	if(dp[cur]!=-1) {
    		return dp[cur];
    	}
    	if(s.charAt(cur)=='0') {
    		dp[cur]=0;
    		return 0;
    	}
    	long ans = violentNumDecodingWithDp(s,cur+1,dp)*(s.charAt(cur)=='*'?9:1);
    	if(s.charAt(cur)=='*') {
    		if(cur+1<s.length()&&s.charAt(cur+1)!='*') {
    			if(s.charAt(cur+1)<='6') {
    				ans+=2*violentNumDecodingWithDp(s,cur+2,dp);
    			}else {
    				ans+=violentNumDecodingWithDp(s,cur+2,dp);
    			}
    		}else if(cur+1<s.length()&&s.charAt(cur+1)=='*') {
    			ans+=15*violentNumDecodingWithDp(s,cur+2,dp);
    		}
    	}else {
    		if(cur+1<s.length()&&s.charAt(cur+1)!='*') {
    			if((s.charAt(cur)-'0')*10+(s.charAt(cur+1)-'0')<=26) {
    				ans+=violentNumDecodingWithDp(s,cur+2,dp);
    			}
    		}else if(cur+1<s.length()&&s.charAt(cur+1)=='*') {
    			if(s.charAt(cur)=='1') {
    				ans+=9*violentNumDecodingWithDp(s,cur+2,dp);
    			}else if(s.charAt(cur)=='2') {
    				ans+=6*violentNumDecodingWithDp(s,cur+2,dp);
    			}
    		}
    	}
    	ans %= esp;
    	dp[cur]=ans;
    	return ans;
    }
}
