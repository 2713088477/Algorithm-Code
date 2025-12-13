package dpDay2;

public class SolutionLeetCode940 {
    public int distinctSubseqII(String s) {
    	int mod=(int)1e9+7;
    	char[] str=s.toCharArray();
    	int[] cnt = new int[26];
    	int all=1,newAdd;
    	for(char x:str) {
    		newAdd=(all-cnt[x-'a']+mod)%mod;
    		cnt[x-'a']=(cnt[x-'a']+newAdd)%mod;
    		all=(all+newAdd)%mod;
    	}
    	return (all-1+mod)%mod;
    }
}
