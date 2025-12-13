package dp;

public class SolutionLeetCode53 {
    public int maxSubArray(int[] nums) {
    	/**
    	 * 解法一:定长滑动窗口暴力求解,超时
    	 */
        //return findMaxSubArray(nums);
    	
    	/**
    	 * 解法二:利用动态规划的思想
    	 */
    	return f2(nums);
    }
    //利用滑动窗口暴力求解(超时了O.o)
    public int findMaxSubArray(int[] nums) {
    	int ans=Integer.MIN_VALUE;
    	for(int k=1;k<=nums.length;k++) {
    		int sum=0;
    		for(int right=0;right<nums.length;right++) {
    			if(right-k+1<0) {
    				sum+=nums[right];
    				continue;
    			}
    			ans=Math.max(ans, sum);
    			sum-=nums[right-k+1];
    		}
    	}
    	return ans;
    }
    //表示以cur开头的最大连续子数组和
    public int f2(int[] nums) {
    	int[] dp=new int[nums.length];
    	dp[nums.length-1]=nums[nums.length-1];
    	for(int i=nums.length-2;i>=0;i--) {
    		dp[i]=Math.max(nums[i], nums[i]+dp[i+1]);
    	}
    	int ans=Integer.MIN_VALUE;
    	for(int i=0;i<nums.length;i++) {
    		ans=Math.max(ans, nums[i]);
    	}
    	return ans;
    }
}
