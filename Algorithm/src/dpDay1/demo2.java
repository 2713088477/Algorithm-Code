package dpDay1;

public class demo2 {
	private static int des = (int)1e9+7;
	public static void main(String[] args) {
		System.out.println(fib1(100));
		System.out.println(fib2(100));
	}
	public static int fib1(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++) {
        	dp[i]=(dp[i-1]%des+dp[i-2]%des)%des;
        	System.out.println("dp["+i+"]="+dp[i]);
        }
        return dp[n];
    }
	public static int fib2(int n) {
        int lastlast = 0,last=1;
        if(n==0)return lastlast;
        if(n==1)return last;
        int cur=0;
        for(int i=2;i<=n;i++) {
        	cur=(lastlast%des+last%des)%des;
        	lastlast=last;
        	last=cur;
        }
        return cur;
    }
	
}
