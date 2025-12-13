package dpDay2;

public class SolutionLeetCode264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2,p2=1,p3=1,p5=1,a,b,c,cur;i<=n;i++) {
        	a=dp[p2]*2;
        	b=dp[p3]*3;
        	c=dp[p5]*5;
        	cur = Math.min(Math.min(a, b), c);
        	if(a==cur) {
        		p2++;
        	}
        	if(b==cur) {
        		p3++;
        	}
        	if(c==cur) {
        		p5++;
        	}
        	dp[i]=cur;
        }
        return dp[n];
    }
}
