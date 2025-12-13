package dpDay2;

public class SolutionLeetCode467 {
    public int findSubstringInWraproundString(String s) {
        int[] sArr = new int[s.length()];
        for(int i=0;i<s.length();i++) {
        	sArr[i]=s.charAt(i)-'a';
        }
        int[] dp=new int[26];
        dp[sArr[0]]=1;
        for(int i=1,cur,pre,len=1;i<s.length();i++) {
        	cur=sArr[i];
        	pre=sArr[i-1];
        	if((pre==25&&cur==0)||pre+1==cur) {
        		len++;
        	}else {
        		len=1;
        	}
        	dp[cur]=Math.max(dp[cur], len);
        }
        int ans=0;
        for(int i:dp) {
        	ans+=i;
        }
        return ans; 
    }
}
