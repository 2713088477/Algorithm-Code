package VideoZuo30;

public class OneKindNumLessMTimes {
    public int lessMNumber(int[] nums,int m) {
    	int[] cnt=new int[32];
    	for(int num:nums) {
    		for(int i=0;i<32;i++) {
    			if((num&(1<<i))!=0) {
    				cnt[i]++;
    			}
    		}
    	}
    	int ans=0;
    	for(int i=0;i<32;i++) {
    		if(cnt[i]%m!=0) {
    			 ans= ans | (1<<i);
    		}
    	}
    	return ans;
        
    }
}
